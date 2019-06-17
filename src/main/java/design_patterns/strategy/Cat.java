package design_patterns.strategy;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 03:15
 * @Description:
 */
public class Cat implements TestComparable<Cat> {
    int w;
    int h;

    public Cat(int w, int h) {
        this.w = w;
        this.h = h;
    }



    @Override
    public String toString() {
        return "Cat{" +
                "w=" + w +
                ", h=" + h +
                '}';
    }


    @Override
    public int comparTo(Cat o) {
        if (this.w>o.w) return 1;
        else if (this.w<o.w) return -1;
        else return 0;
    }
}
