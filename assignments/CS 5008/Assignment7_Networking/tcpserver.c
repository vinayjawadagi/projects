// Compile with: gcc tcpserver.c -o tcpserver
//
// Implement tcp server below.
// Our standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// Some types and unix operations
#include <sys/types.h>
#include <unistd.h>


// A sockets library and internet protocol library
#include <sys/socket.h>
#include <netinet/in.h>


#include <sys/wait.h>


void read_command(char* args[], char input[]) {
    int i = 0;
    char* token;
    
    token = strtok(input, " \n");
    
    while(token != NULL){
        args[i] = malloc(strlen(token) + 1);
        strcpy(args[i],token);
        i++;
        token = strtok( NULL, " \n");
    }
    
    args[i] = NULL;
}

void free_command(char* arguments[]){
    for (int i = 0; arguments[i] != NULL; i++) {
        free(arguments[i]);
    }
}

int main(int argc, const char * argv[]) {
    
    // Create the server socket
    int server_socket;
    //            domain, type         ,protocol
    // domain = AF_INET(IPv4) or AF_INET6
    server_socket = socket(AF_INET, SOCK_STREAM, 0);
    // define the server address format
    struct sockaddr_in server_address;
    
    
    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(9002); // 9002 is choosen arbitrarily. Try other ports if this does not work
    server_address.sin_addr.s_addr = htons(INADDR_ANY);
    
    bind(server_socket, (struct sockaddr*) &server_address, sizeof(server_address));
    printf("Server bind()\n");
    
    listen(server_socket, 27);
    
    int client_socket;
    
    // Accept connection
    while((client_socket = accept(server_socket, NULL, NULL)) > 0){
        // send a message from the server
        char server_message[256] = "You have reached the server";
        char client_message[256];
        char user_name[20];
        char cmd[20];
        
        //send the connection sucessful message and get the username from the client
        send(client_socket, server_message, sizeof(client_message), 0);
        recv(client_socket, user_name, sizeof(user_name), 0);
        printf("Client has joined: %d \n",server_socket);
        printf("> %s \n",user_name);
        
        //start taking user input
        while(1){
            char* arguments[20];
            strcpy(client_message, "");
            recv(client_socket, client_message, sizeof(client_message), 0);
            if(strcmp(client_message, "exit") == 0){
                strcpy(client_message, "");
                break;
            }
            printf("%s \n",client_message);
            read_command(arguments, client_message);
            if(fork() == 0){
                strcpy(cmd, "/bin/");
                strcat(cmd, arguments[0]);
                strcpy(arguments[0],cmd);
                
                execve(arguments[0], arguments, NULL);
                free_command(arguments);
                exit(1);
            }
            else{
                wait(NULL);
            }
        }
        close(client_socket);
    }
    
    // Terminate
    close(server_socket);
    
    return 0;
}

