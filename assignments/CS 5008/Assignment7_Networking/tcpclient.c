// Note: I recommend implementing the tcpserver.c first.
//
// Compile with: gcc tcpclient.c -o tcpclient
//
// Implement tcp client below.
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#include <sys/types.h>
#include <sys/socket.h>


#include <unistd.h>
#include <netinet/in.h>


int main(int argc, const char * argv[]) {
    
    // Create a socket
    int client_socket;
    if((client_socket = socket(AF_INET, SOCK_STREAM, 0)) < 0){
        printf("\n Socket creation error \n");
    }
    
    // Our client will connect to a server with the following address and port.
    struct sockaddr_in server_address;
    server_address.sin_family = AF_INET; // 32-bit IPV4 address
    server_address.sin_port = htons(9002); // convert to the appropriate port number using htons
    server_address.sin_addr.s_addr = htons(INADDR_ANY); // Our ip address, which is localhost using INADDR_ANY
    
    // Attempt to connect
    // Returns an integer as an error code (zero means everything worked)
    int connection_status;
    
    // If connection is busy wait till you get the connection
    while(connect(client_socket, (struct sockaddr*)&server_address, sizeof(server_address)) != 0){
        continue;
    }
    
    // Receive data from the server
    char server_response[256];
    char user_name[20];
    char client_response[256];
    // get the username
    printf("What's your username? \n");
    scanf("%s",&user_name);
    
    
    // receive the message from server and print it
    recv(client_socket, &server_response, sizeof(server_response), 0);
    send(client_socket, user_name, sizeof(user_name), 0);
    printf("The server sent the data: %s\n",server_response);
    while(1){
        if(strcmp(client_response, "exit") == 0){
            send(client_socket, client_response, sizeof(client_response), 0);
            break;
        }
        
        // get the command from the user
        strcpy(client_response, "");
        printf("%s> ",user_name);
        fgets(client_response, 256, stdin);
        client_response[strcspn(client_response, "\n")] = 0;
        
        send(client_socket, client_response, sizeof(client_response), 0);
    }
    
    // Then close the socket
    close(client_socket);
    return 0;
}
