import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;

@Entity
@ExcludeSuperclassListeners
public class EntityListenersDipnotuKullanimi extends ListenersKullanimi {

}

/*
try {
    em.getTransaction().begin();
    // Varl�k nesnelerinin i�lem kodlar� bu arada olur.
    em.getTransaction().commit();
}
finally {
    if (em.getTransaction().isActive()) //E�er transaction aktifse
        em.getTransaction().rollback(); //t�m i�lemleri ba�a geri sar.
}
*/














