package DS.function;

import DS.common.*;

import java.util.*;

public class TSP {
    private Matrix graph;
    private ArrayList<Integer> wayToPoint;
    private HashMap<Integer, Integer> reflectToNum;
    private TSP_solution bestSolution;

    public TSP(Navigator Navi){
        this.wayToPoint = new ArrayList<>();
        this.wayToPoint.add(Navi.getBeginNum());
        this.wayToPoint.addAll(Navi.getWayToPoint());
        this.wayToPoint.add(Navi.getEndNum());
        graph = new Matrix(Navi, wayToPoint.size());
    }
    private int CalculateLength(Matrix G, TSP_solution newSolution){
        int _length = 0;

        for (int i = 1; i <= G.vex_num; i++)
        {
            int _startCity = (int)newSolution.path[i];
            int _endCity = (int)newSolution.path[i + 1];
            if (G.arcs[_startCity][_endCity] == -1)
            {
                return Constants.inf;
            }
            else{
                _length += G.arcs[_startCity][_endCity];
            }
        }

        // 判断该路径是否能回到起始城市
        if (G.arcs[(int)newSolution.path[G.vex_num - 1]][(int)newSolution.path[0]] == -1)
        //TODO:把回到起始城市改为回到终点城市
        {
            return Constants.inf;
        }
        else{
            _length += G.arcs[(int)newSolution.path[G.vex_num - 1]][(int)newSolution.path[0]];
            // cout<<"_length = "<<_length<<endl;
            return _length;
        }

    }
    TSP_solution FindNewSolution(Matrix G, TSP_solution bestSolution){
        // 产生新的解
        TSP_solution newSolution = bestSolution;

        // 起始城市固定为A, 终点也要返回A, 即需要关注起点A和终点A之间的所有城市
//        int i = rand() % (G.vex_num - 1) + 1;	// % 取余 -> 即将随机数控制在[1, G.vex_num - 1]
//        int j = rand() % (G.vex_num - 1) + 1;
        int i = (int)(Math.random() * G.vex_num) + 1;
        int j = (int)(Math.random() * G.vex_num) + 1;
        if (i > j)
        {
            int temp = i;
            i = j;
            j = temp;
        }
        else if (i == j)
        {	// 表示产生的随机数没有改变的作用, 将此路程设置为最大并结束该函数
            return newSolution;
        }

        /* way 2 */
        int choose = (int)(Math.random() * 3);
        if (choose == 0)
        {	// 随机交换任意两个城市的位置
            int temp = newSolution.path[i];
            newSolution.path[i] = newSolution.path[j];
            newSolution.path[j] = temp;
        }else if (choose == 1)
        {	// 随机逆置城市的位置
//            Collection.reverse(bestSolution.path + i, bestSolution.path + j);
            for(int k = i; k <= (i + j) / 2; k++){
                int temp = newSolution.path[k];
                newSolution.path[k] = newSolution.path[i + j - k];
                newSolution.path[i + j - k] = temp;
            }
        }
        else{	// 随机移位城市的位置
            if (j + 1 == G.vex_num) //边界处不处理
            {
                return newSolution;
            }
//            rotate(bestSolution.path + i, bestSolution.path + j, bestSolution.path + j + 1);
            int first = i;
            int middle = j;
            for(int k = middle;;){
                int temp = newSolution.path[first];
                newSolution.path[first] = newSolution.path[k];
                newSolution.path[k] = temp;
                ++first;
                ++k;
                if(first == j){
                    if(k == j + 1) break;
                    middle = k;
                }
                else if(k == j + 1){
                    k = middle;
                }
            }
        }
        // 载入起点与终点
        newSolution.path[G.vex_num] = wayToPoint.get(wayToPoint.size() - 1);

        newSolution.length_path = CalculateLength(G, newSolution);
        return newSolution;
    }


    TSP_solution SA_TSP(Matrix G){

        // 当前温度
        double Current_Temperature = Constants.INITIAL_TEMPERATURE;

        // 最优解
        TSP_solution Best_solution = new TSP_solution();
        Best_solution.length_path = Constants.inf;
        // 初始路径
        for (int i = 1; i <= G.vex_num; i++)
        {
            Best_solution.path[i] = i;
        }
        ArrayUtils.shuffle(Best_solution.path, 1, G.vex_num - 1);

        // 当前解, 与最优解比较
        TSP_solution Current_solution;

        // 模拟退火过程
        while(Constants.MIN_TEMPERATURE < Current_Temperature){
            // 满足迭代次数
            for (int i = 0; i < Constants.LEGNTH_Mapkob; i++)
            {
                Current_solution = FindNewSolution(G, Best_solution);
                if (Current_solution.length_path <= Best_solution.length_path)	// 接受新解
                {
                    Best_solution = Current_solution;
                }
                else{	// 按 Metropolis 判断是否接受
                    if ((int)Math.exp((Best_solution.length_path - Current_solution.length_path) / Current_Temperature) > Math.random())
                    {
                        Best_solution = Current_solution;
                    }
                }
            }
            Current_Temperature *= Constants.SPEED;  // 按 SPEED 速率退火

        }

        return Best_solution;
    }
    //TODO:未测试
}

class Matrix{
    public int[][] arcs;
    public int vex_num, arc_num;

    public Matrix(Navigator Navi, int n){
        //TODO:初始化
    }
}

class TSP_solution{
    //TODO：初始化
    public int length_path;
    public Integer[] path;
}

class ArrayUtils {

    private static Random rand = new Random();

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(T[] arr, int start, int end) {
        int length = arr.length;
        for (int i = end; i > start; i--) {
            int randInd = rand.nextInt(i - start) + start;
            swap(arr, randInd, i - 1);
        }
    }
}