import java.util.Arrays;
class Testprogram {
public static void main(String[] args) {
Person[] personer = {
new Person("Andreas", "Hurthe", 25),
new Person("Kristine", "Henriksen", 30),
new Person("Henrik", "Golsen", 25),
new Person("Sigvart", "Dagsland", 29)
};
Arrays.sort(personer);
for (Person p : personer) {
System.out.println(p);
}
}
}
