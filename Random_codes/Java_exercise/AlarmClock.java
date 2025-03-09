import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);

                LocalTime currentTime = LocalTime.now();

                int hours = currentTime.getHour();
                int minutes = currentTime.getMinute();
                int seconds = currentTime.getSecond();
                System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("\n*Alarm noises*");
        playSound(filePath);
    }

    private void playSound(String filePath) {
        File audioFile = new File(filePath);
        try (AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            String text;
            System.out.print("Press ENTER to stop the alarm: ");
            do
                text = scanner.nextLine();
            while(!text.isEmpty());
            clip.stop();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported!");
        }
        catch (LineUnavailableException e) {
            System.out.println("Unable to access the audio file!");
        }
        catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}