public interface Visitatore<T> {
    public boolean hasNext();
    public T next();
    public T goTesta();
    public T goBottom();
}
