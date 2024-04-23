#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

void signal_handler (int sig) {
    write(1,"\n mini-shell terminated.\n",35);
    exit(0);
}

void read_command(char* args[]) {
    char input[80];
    int i = 0;
    char* token;
    
    fgets(input,sizeof(input),stdin);
    
    token = strtok(input, " \n");
    
    while(token != NULL){
        args[i] = malloc(strlen(token) + 1);
        strcpy(args[i],token);
        i++;
        token = strtok( NULL, " \n");
    }
    
    args[i] = NULL;
}

void update_history(char* arguments[], char* history[], int count){
    char* h_command = malloc(sizeof(char) * 80);
    for(int i = 0; arguments[i] != NULL; i++){
        strcat(h_command,arguments[i]);
        strcat(h_command, " ");
    }
    history[count] = malloc(strlen(h_command) + 1);
    strcpy(history[count],h_command);
    history[count+1] = NULL;
    free(h_command);
}
void clear_history(char* history[]){
    for(int i = 0; history[i] != NULL; i++){
        free(history[i]);
    }
}

void print_history(char* history[]){
    for(int i = 0; history[i] != NULL; i++){
        printf("%s \n",history[i]);
    }
}

void free_command(char* arguments[]){
    for (int i = 0; arguments[i] != NULL; i++) {
        free(arguments[i]);
    }
}

int main(){
    signal(SIGINT, signal_handler);
    
    char command[20];
    char cmd[20];
    char* arguments[20];
    
    char* history[100];
    int history_count = 0;
    
    char* available_cmd[] = {"exit", "cd", "ls", "cat", "pwd","help", "history"};
    int is_available;
    int itr;
    printf("Welcome to my shell, use command 'help' to know the list of available commands. \n");
    while(1){
        is_available = 0;
        itr = 0;
        printf("mini-shell>");
        read_command(arguments);
        strcpy(command, arguments[0]);
        
        while(itr < 7){
            if(!strcmp(available_cmd[itr], command)){
                is_available = 1;
                break;
            }
            else
                itr++;
        }
        if(is_available == 0){
            printf("Command not available. Use command 'help' to get the list of available commands. \n");
            free_command(arguments);
            continue;
        }
        if(strcmp(command, "history")){
            if(history_count < 99){
                update_history(arguments, history, history_count);
                history_count++;
            }
            else{
                clear_history(history);
                history_count = 0;
                update_history(arguments, history, history_count);
                history_count++;
            }
        }
        
        if(strcmp(command, "help") == 0){
            printf("The available commands are: \n");
            printf("\n");
            printf("'cd' : changes the current directory. \n Syntax: \n cd :Changes the directory to the home directory. \n cd .. :changes the directory to previous folder. \n");
            printf(" cd 'path' : changes the dorectory to the speicifed path. \n");
            printf("\n");
            printf("'ls' : lists the files in the current directory \n");
            printf(" Syntax: \n ls \n");
            printf("\n");
            printf("'cat' : Shows the contents of the specified file. \n Syntax: \n cat file-name : opens the specified file. \n");
            printf("\n");
            printf("'pwd' : Shows the current path. \n Syntax: \n pwd \n");
            printf("\n");
            printf("'exit' : exits the mini-shell. \n Syntax: \n exit \n");
            printf("\n");
            printf("'history' : prints the history of the commands used by the user \n");
            printf(" Syntax: \n history \n");
            free_command(arguments);
            
        }
        else if(strcmp(command, "history") == 0){
            print_history(history);
            free_command(arguments);
            
        }
        else if(strcmp(command, "cd") == 0){
            if(arguments[1] == NULL)
                chdir(getenv("HOME"));
            else if(strcmp("..",arguments[1]) == 0){
                chdir("..");
            }
            else{
                char cwd[100];
                getcwd(cwd,100);
                chdir(strcat(cwd,"/"));
                chdir(strcat(cwd,arguments[1]));
            }
            free_command(arguments);
        
        }
        else if(strcmp(command, "exit") == 0){
            clear_history(history);
            free_command(arguments);
            break;
        }
        else{
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
    }
    
    return 0;
}
