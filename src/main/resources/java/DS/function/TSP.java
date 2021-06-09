package DS.function;

import DS.common.*;

import java.util.*;

public class TSP {
    public Matrix G;
    private ArrayList<Integer> wayToPoint;
    private HashMap<Integer, Integer> reflectToNum;
    private TSP_solution bestSolution;
    private int start, end;
    private static int vis[];
//    private int bound;

    public TSP(Navigator Navi){
        this.wayToPoint = new ArrayList<>();
        this.wayToPoint.addAll(Navi.getWayToPoint());
        G = new Matrix(Navi, wayToPoint.size());
        this.start = 0;
        this.end = G.vex_num - 1;
    }

    private double CalculateLength(TSP_solution newSolution){
        int _length = 0;

        for (int i = 0; i < G.vex_num - 1; i++)
        {
            int _startCity = newSolution.path[i];
            int _endCity = newSolution.path[i + 1];
            if (G.arcs[_startCity][_endCity] == -1)
            {
                return Constants.inf;
            }
            else{
                _length += G.arcs[_startCity][_endCity];
            }
        }
//        _length += G.arcs[newSolution.path[0]][newSolution.path[1]] + G.arcs[newSolution.path[G.vex_num]][newSolution.path[G.vex_num + 1]];
        // cout<<"_length = "<<_length<<endl;
        return _length;

    }
    TSP_solution FindNewSolution(TSP_solution bestSolution){
        // 产生新的解
        TSP_solution newSolution = new TSP_solution(G.vex_num);
        newSolution.copy(bestSolution);

        // 起始城市固定为A, 终点也要返回A, 即需要关注起点A和终点A之间的所有城市
//        int i = rand() % (G.vex_num - 1) + 1;	// % 取余 -> 即将随机数控制在[1, G.vex_num - 1]
//        int j = rand() % (G.vex_num - 1) + 1;
        int i = (int)(Math.random() * (G.vex_num - 2)) + 1;
        int j = (int)(Math.random() * (G.vex_num - 2)) + 1;
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
            if (j + 1 == G.vex_num - 2) //边界处不处理
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
//        newSolution.path[G.vex_num] = wayToPoint.get(wayToPoint.size() - 1);

        newSolution.length_path = CalculateLength(newSolution);
        return newSolution;
    }


    TSP_solution SA_TSP(){

        // 当前温度
        double Current_Temperature = Constants.INITIAL_TEMPERATURE;

        // 最优解
        TSP_solution Best_solution = new TSP_solution(G.vex_num);
        Best_solution.length_path = Constants.inf;
        // 初始路径
        for (int i = 0; i < G.vex_num; i++)
        {
            Best_solution.path[i] = i;
        }
        ArrayUtils.shuffle(Best_solution.path, 1, G.vex_num - 2);

        // 当前解, 与最优解比较
        TSP_solution Current_solution = new TSP_solution(G.vex_num);

        // 模拟退火过程
        while(Constants.MIN_TEMPERATURE < Current_Temperature){
            // 满足迭代次数
            for (int i = 0; i < Constants.LEGNTH_Mapkob; i++)
            {
                if ((int)Math.exp((Best_solution.length_path - Current_solution.length_path) / Current_Temperature) > Math.random())
                {// 按 Metropolis 判断是否接受
                    Current_solution = FindNewSolution(Best_solution);
                }
                if (Current_solution.length_path < Best_solution.length_path)	// 接受新解
                {
                    Best_solution = Current_solution;
                }
            }
            Current_Temperature *= Constants.SPEED;  // 按 SPEED 速率退火

        }

        return Best_solution;
    }
    void BSM_dfs(int u, int k, TSP_solution currentSolution, double learningRate){
        if(k == G.vex_num - 1){
            double _length = currentSolution.length_path;
            if(_length + G.arcs[u][end] < learningRate * bestSolution.length_path) {
                bestSolution.copy(currentSolution);
                bestSolution.length_path = _length + G.arcs[u][end];
            }
            return;
        }
        double _length = currentSolution.length_path;
        double bound = bestSolution.length_path * learningRate;
        for(int i = 1; i < G.vex_num - 1; i++){
            if(vis[i] != 0 || G.arcs[u][i] + _length > bound) continue;
            vis[i] = 1;
            currentSolution.length_path += G.arcs[u][i];
            currentSolution.path[k] = i;
            BSM_dfs(i, k + 1, currentSolution, learningRate);
            currentSolution.length_path -= G.arcs[u][i];
            currentSolution.path[k] = 0;
            vis[i] = 0;
        }
    }
    TSP_solution BSM_dfs_TSP(){
        vis = new int[G.vex_num];
        bestSolution = new TSP_solution(G.vex_num);
        bestSolution.length_path = Constants.inf;
//        for (int i = 0; i < G.vex_num; i++)
//        {
//            bestSolution.path[i] = i;
//        }
        TSP_solution currentSolution = new TSP_solution(G.vex_num);
        currentSolution.path[0] = start;
        currentSolution.length_path = 0;
        currentSolution.path[G.vex_num - 1] = end;
        double learningTate = 0.8;
        BSM_dfs(0, 1, currentSolution, learningTate);
        return bestSolution;
    }
    int getInitNum(int index){
        return G.getInitNum(index);
    }
    //TODO:未测试
}

class Matrix{
    public double[][] arcs;
    public int vex_num, arc_num;
    private HashMap<Integer, Integer> reflectToNum;
    private HashMap<Integer, Integer> inv;

    public Matrix(Navigator Navi, int n){
        reflectToNum = new HashMap<>();
        inv = new HashMap<>();
        vex_num = n + 2;
        ArrayList<Integer> wayToBy = new ArrayList<>();
        wayToBy.add(Navi.getBeginNum());
        wayToBy.addAll(Navi.getWayToPoint());
        wayToBy.add(Navi.getEndNum());
        for(int i = 0; i < vex_num; i++){
            reflectToNum.put(i, wayToBy.get(i));
            inv.put(wayToBy.get(i), i);
        }
        arcs = new double[wayToBy.size() + 5][];
        //init
        for(int i = 0; i < vex_num + 5; i++) {
            arcs[i] = new double[wayToBy.size() + 5];
        }
        for(int i = 0; i < vex_num; i++){
            for(int j = 0; j < vex_num; j++){
                if(i == j) arcs[i][j] = 0;
                else{
                    arcs[i][j] = Navi.Dijkstra(wayToBy.get(i), wayToBy.get(j));
                    Navi.clearRoute();
                    arcs[j][i] = arcs[i][j];
                }
            }
        }
    }
    int getInitNum(int index){
        return reflectToNum.get(index);
    }


}

class TSP_solution {
    //TODO：初始化, 映射
    public double length_path;
    public Integer[] path;

    public TSP_solution(int x) {
        path = new Integer[x + 5];
        length_path = Constants.inf;
    }

//    public int getInitNum(int x){
//        return inv.get(x);
//    }
    public void copy(TSP_solution x){
        this.length_path = x.length_path;
        this.path = x.path.clone();
    }
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