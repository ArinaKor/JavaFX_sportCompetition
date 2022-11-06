package client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) {
        try {
        this.serverSocket = serverSocket;
        this.socket = serverSocket.accept();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void sport_competitions_send(String clientMessageRecieved1, String clientMessageRecieved2, String clientMessageRecieved3, String clientMessageRecieved4) throws IOException {
        try{
            bufferedReader.read(clientMessageRecieved1.toCharArray());
            bufferedReader.read(clientMessageRecieved2.toCharArray());
            bufferedReader.read(clientMessageRecieved3.toCharArray());
            bufferedReader.read(clientMessageRecieved4.toCharArray());
        HashMap<Integer, String> competitions = new HashMap<>();
        competitions.put(1, "Бубликова");
        competitions.put(2, "Серебряков");
        competitions.put(3, "Трамп");
        competitions.put(4, "Лукошкина");
        System.out.println("С клиента были получены данные: ");
        System.out.println("1 участник прыгнул: '"+clientMessageRecieved1+" см'  ("+competitions.get(1)+")");
        System.out.println("2 участник прыгнул: '"+clientMessageRecieved2+" см'  ("+competitions.get(2)+")");
        System.out.println("3 участник прыгнул: '"+clientMessageRecieved3+" см'  ("+competitions.get(3)+")");
        System.out.println("4 участник прыгнул: '"+clientMessageRecieved4+" см'  ("+competitions.get(4)+")");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(clientMessageRecieved1));
        list.add(Integer.valueOf(clientMessageRecieved2));
        list.add(Integer.valueOf(clientMessageRecieved3));
        list.add(Integer.valueOf(clientMessageRecieved4));
        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, String> competitions1 = new TreeMap<>(Collections.reverseOrder());
        competitions1.put(Integer.valueOf(clientMessageRecieved1), "Бубликова");
        competitions1.put(Integer.valueOf(clientMessageRecieved2), "Серебряков");
        competitions1.put(Integer.valueOf(clientMessageRecieved3), "Трамп");
        competitions1.put(Integer.valueOf(clientMessageRecieved4), "Лукошкина");
        System.out.println(competitions1);
        for(int i=0;i<3;i++){
            bufferedWriter.write(competitions1.get(list.get(i)));
        }
        bufferedWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("error sending message to the client");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(bufferedWriter!=null){
                bufferedWriter.close();
            }
            if(socket!=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
