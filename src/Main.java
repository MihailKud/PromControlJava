import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // блок кода для считывания из файла всей текстовой информации и формирования
        // итоговой строки (тип данных StringBuilder)
        String contentFile;
        StringBuilder contentFileSum = new StringBuilder();
        String pathFile = "D:\\PromControl_Java\\src\\input.txt";
        try{
            BufferedReader input = new BufferedReader(new FileReader(pathFile));
            while ((contentFile=input.readLine()) != null){
                contentFileSum.append(contentFile).append(" ");
            }
            input.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        // формирование массива отельных слов (включая пустые символы и т.д.)
        String[] words = contentFileSum.toString().split(" ");

        // блок кода для определения самого длинного слова в файле
        int wordLengthMax = words[0].length();
        String wordValue = words[0];
        for (int i = 1; i < words.length; i++){
            if (words[i].length() > wordLengthMax){
                wordLengthMax = words[i].length();
                wordValue = words[i];
            }
        }
        System.out.println("Самое длинное слово в файле - " + wordValue);
        System.out.println("Его длина равна " + wordLengthMax);

        // блок кода для определения в отношении каждого слова количества его вхождений в файл
        Map<String, Double> dict = new HashMap<String, Double>();
        for (int i = 0; i < words.length; i++){
            if (dict.containsKey(words[i])){
                dict.put(words[i], dict.get(words[i]) + 1.0);
            } else {
                dict.put(words[i], 1.0);
            }
        }
        // убираем нулевые символы
        dict.remove("");

        // блок кода для определения частоты вхождения слова
        double wordsNumber = 0.0;
        for (String ww : dict.keySet()){
            wordsNumber = wordsNumber + dict.get(ww);
        }
        for (String ww : dict.keySet()){
            dict.put(ww, dict.get(ww) / wordsNumber);
        }

        System.out.println(dict.toString());
        System.out.println("Количество слов в файле = " + (int)wordsNumber);
    }
}