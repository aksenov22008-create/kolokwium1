public record Vec2(double x, double y) {

    /*
     * Конструктор копіювання.
     *
     * this(...)
     * викликає інший конструктор.
     */
    public Vec2(Vec2 old) {
        this(old.x, old.y);
    }
}