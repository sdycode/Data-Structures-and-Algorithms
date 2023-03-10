public class DynamicQueue extends  CircularQueue{

    DynamicQueue() {
        super();
    }

    DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(isFull()){
            int[] temp = new int[data.length*2];
            for (int i = 0; i <data.length ; i++) {
                temp[i]= data[(i+front)%data.length];
            }
            front =0;
            end =data.length;
//            Then assign this new temp array to origina lrray
            data = temp;
        }
        return super.insert(item);
    }
}
