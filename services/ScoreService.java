package services;

public final class ScoreService<E>{
    
    public E calculateScore(E first,E second,E third){
        E result = null;

        result = (E) new Double(((Double)first*0.3)+((Double)second*0.3)+((Double)third*0.4));

        return result;
    }
}