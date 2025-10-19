package IteratorDesignPattern;

import java.util.List;

public class MyIteratorImpl implements MyIterator{

    List<User> list;
    private int length;

    private int position = 0;

    MyIteratorImpl(List<User> list){
        this.list = list;
        this.length = list.size();
    }

    @Override
    public boolean hasNext() {
        if(position>=length){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        User user = (User) list.get(position);
        position++;
        return user;
    }
}
