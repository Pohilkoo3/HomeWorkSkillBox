public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextIntoWords(String text) {
    if (text.isEmpty()){
      return "";
    }
    String regex = "[.,0-9\\-;:]";
    String textReplace = (text.replaceAll(regex, " "));
    String words[] =textReplace.split("\\s+");
    StringBuilder wordString = new StringBuilder();
    for (int i = 0; i < words.length; i++){
      wordString.append(words[i]).append("\n");
    }
    return (wordString.toString()).trim();
  }
}