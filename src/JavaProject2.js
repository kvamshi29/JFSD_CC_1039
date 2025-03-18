import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

public class RamAssistant {

    // Text-to-Speech method
    private static void speak(String text) {
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        Voice voice = VoiceManager.getInstance().getVoice("kevin16");

        if (voice != null) {
            voice.allocate();
            voice.speak(text);
            voice.deallocate();
        } else {
            System.out.println("Voice not found!");
        }
    }

    // Main method
    public static void main(String[] args) {
        Configuration config = new Configuration();

        try {
            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(config);
            recognizer.startRecognition(true);

            speak("Hello, I am Ram, your virtual assistant. How can I help you today?");

            SpeechResult result;
            while ((result = recognizer.getResult()) != null) {
                String command = result.getHypothesis().toLowerCase();
                System.out.println("You said: " + command);

                // Basic Commands
                if (command.contains("hello")) {
                    speak("Hello! How are you?");
                } else if (command.contains("time")) {
                    speak("The current time is " + java.time.LocalTime.now());
                } else if (command.contains("date")) {
                    speak("Today's date is " + java.time.LocalDate.now());
                } else if (command.contains("exit")) {
                    speak("Goodbye! Have a nice day.");
                    System.exit(0);
                } else {
                    speak("I didn't understand that command.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}