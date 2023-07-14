public class dz3 {

  /**
   * Метод запуска сортировки массива
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {1234, 4, 7, 2, 1, -3, 0, 567, 45, 90, 34,2, 234};

    heapSort(arr);

    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }

  /**
   * Метод создания дерева массива
   * @param arr
   */
  public static void heapSort(int[] arr) {
    //длина массива
    int n = arr.length;

    //создаём дерево, построение кучи (перегруппируем массив)
    for(int i  = n / 2 - 1; i >= 0; i--)
      heapify(arr, i , n);

    //Делаем сортировку массива, уже отсортированного дерева,
    //Один за другим извлекаем элементы из кучи
    for (int i = n - 1; i >= 0; i--){

      // Перемещаем текущий корень в конец
      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;

      // Вызываем процедуру heapify на уменьшенной куче
      heapify(arr, 0, i);
    }

  }

  /**
   * Главный метод в котором будет меняться структура данных
   * так чтоб родитель был максимальны элементом по сравнению
   * со своими детьми в дереве
   * @param arr
   * @param i
   * @param n
   */
  private static void heapify(int[] arr, int i, int n) {
    //левый ребёнок
    int l = i * 2 + 1;

    //правый ребёнок
    int r = i * 2 + 2;

    //Инициализируем наибольший элемент как корень
    int largest = i;

    //Проверка чтоб дети не стали больше чем родители
    //Если левый дочерний элемент больше корня
    if(l < n && arr[l] > arr[largest])
      largest = l;

    //Если правый дочерний элемент больше,
    // чем самый большой элемент на данный момент
    if(r < n && arr[r] > arr[largest])
      largest = r;

    //Если, ребёнок оказался больше родителя, то делаем обмен,
    //ребёнка с родителем. Если самый большой элемент не корень
    if (i != largest){
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      //Проверяем ещё раз чтоб дети были меньше чем родители,
      //если, вдруг у детей есть свои дети
      //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
      heapify(arr, largest, n);
    }
  }
}