package ArrayList_vs_LinkedList;

import java.util.ArrayList;

/*Предложите эффективный алгоритм удаления нескольких
рядом стоящих элементов из середины списка, реализуемого ArrayList.*/
public class AL_remove_n_from_mean_algorithm {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>();

        // fill
        for (int i=0;i < 10;i++){
            AL.add(i, i);
        }
        System.out.println(AL);

        AL.addAll(5, AL.subList(5, 10));
        System.out.println(AL);
    }
}
/*Неизбитый, по моим меркам вопрос, встречался мне всего однажды, когда я не знал механизма удаления
элементов из ArrayList. В итоге вызвал у меня серьезные затруднения. На самом деле все довольно просто
и очевидно, когда знаешь как происходит удаление одного элемента. Допустим нужно удалить n элементов с
позиции m в списке. Вместо выполнения удаления одного элемента n раз (каждый раз смещая на 1 позицию
элементы, стоящие «правее» в списке), нужно выполнить смещение всех элементов, стоящих «правее» n+m
позиции на n элементов левее к началу списка. Таким образом, вместо выполнения n итераций перемещения
элементов списка, все выполняется за 1 проход.*/
