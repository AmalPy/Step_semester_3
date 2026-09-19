import java.util.Arrays;
import java.util.Scanner;

public class Playlist {

    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter maximum number of songs: ");
        int maxSongs = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(maxSongs);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + ": ");
            String song = sc.nextLine();
            playlist.addSong(song);
        }

        String[] copy = playlist.getSongs();

        System.out.println("Songs: " + Arrays.toString(copy));
        System.out.println("Song count: " + playlist.getSongCount());

        sc.close();
    }
}
}