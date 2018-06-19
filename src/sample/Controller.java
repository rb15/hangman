package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Controller implements Initializable {
    public Label text;
    public Label text1;
    public Pane pane;
    public Button a;
    public Button b;
    public Button c;
    public Button d;
    public Button e;
    public Button f;
    public Button g;
    public Button h;
    public Button i;
    public Button j;
    public Button k;
    public Button l;
    public Button m;
    public Button n;
    public Button o;
    public Button p;
    public Button q;
    public Button r;
    public Button s;
    public Button t;
    public Button u;
    public Button v;
    public Button w;
    public Button x;
    public Button y;
    public Button z;

    String cont = "0";



    public String getRandomList(List<String> list) {

        //0-4
        int index = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(index);

    }
    static String word1;
    static String word;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> list = new ArrayList<>();
        list.add("APPLE:fruit");
        list.add("BOY:human");
        list.add("CAT:animal");
        list.add("DOG:animal");
        list.add("ELEPHANT:animal");

        Controller obj = new Controller();
        word1=obj.getRandomList(list);
        String[] ba = word1.split(":",2);
        word=ba[0];
        text1.setText(ba[1]);
        Image hangman = new Image("file:///C:/hangman/"+cont+".png");
        ImageView imag = new ImageView(hangman);
        pane.getChildren().add(imag);

        for(int i=0;i<word.length();i++)
        {
            text.setText(text.getText() + "_");
        }


    }

    public void dodo(ActionEvent actionEvent) {
        boolean ko = true;
        String[] part2 = text.getText().split("");
        String[] part = word.split("");
        ArrayList<Button> li = new ArrayList<>();
        li.add(a); li.add(b); li.add(c); li.add(d); li.add(e); li.add(f); li.add(g); li.add(h); li.add(i); li.add(j);
        li.add(k);li.add(l);li.add(m);li.add(n);li.add(o);li.add(p);li.add(q);li.add(r);li.add(s);li.add(t);li.add(u);
        li.add(v);li.add(w);li.add(x);li.add(y);li.add(z);
        for (Button item:li) {
            if (actionEvent.getSource() == item) {
                if (!word.contains(item.getText())) {
                    ko = false;
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        if (part[i].equals(item.getText())) {
                            part2[i] = item.getText();
                        }
                    }
                }
                text.setText("");
                for (int i = 0; i < word.length(); i++) {
                    text.setText(text.getText() + part2[i]);
                }
                item.setDisable(true);
            }
        }

        if (!ko){
        int cot = Integer.parseInt(cont);
        cot++;
        cont = String.valueOf(cot);
        Image hangman = new Image("file:///C:/hangman/"+cont+".png");
        ImageView imag = new ImageView(hangman);
        pane.getChildren().add(imag);}
        if (word.equals(text.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("you won");
            alert.show();
            for (Button item:li) {
                item.setDisable(true);
            }
        }
        if (cont.equals("6")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("you lose");
            alert.show();
            text.setText(word);
            for (Button item:li) {
                item.setDisable(true);
            }
        }
    }
}
