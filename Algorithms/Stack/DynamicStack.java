public class DynamicStack extends CustomStack {

    DynamicStack() {
        super();
    }

    DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) throws Exception{
        if (super.isFull()) {
            int[] tempArr = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tempArr[i] = data[i];
            }
            data = tempArr;
        }
        return super.push(item);
    }
}
