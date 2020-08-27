package model;

public class Vaga {

    private int id;
    private Boolean status;

    public Vaga(int id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return this.status;
    }
}
