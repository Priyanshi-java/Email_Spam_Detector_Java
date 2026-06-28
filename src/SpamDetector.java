public class SpamDetector {

    public static boolean isSpam(String text) {

        text = text.toLowerCase();

        String[] spamWords = {
                "free",
                "win",
                "winner",
                "iphone",
                "lottery",
                "prize",
                "offer",
                "urgent",
                "click",
                "claim",
                "money",
                "gift"
        };

        for(String word : spamWords){

            if(text.contains(word)){
                return true;
            }

        }

        return false;

    }

}