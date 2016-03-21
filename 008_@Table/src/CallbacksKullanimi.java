import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
public class CallbacksKullanimi {
	@PrePersist
	void kaydetmeOncesi() {
		System.out.println("KAYDETME �NCES�NDE �A�IRILIR");
	}

	@PostPersist
	void kaydetmeSonrasi() {
		System.out.println("KAYDETME SONRASINDA �A�IRILIR");
	}

	@PostLoad
	void yuklemeSonrasi() {
		System.out.println("Y�KLEME SONRASINDA �A�IRILIR");
	}

	@PreUpdate
	void guncellemeOncesi() {
		System.out.println("G�NCELLEME �NCES�NDE �A�IRILIR");
	}

	@PostUpdate
	void guncellemeSonrasi() {
		System.out.println("G�NCELLEME SONRASINDA �A�IRILIR");
	}

	@PreRemove
	void silmeOncesi() {
		System.out.println("S�LME �NCES�NDE �A�IRILIR");
	}

	@PostRemove
	void silmeSonrasi() {
		System.out.println("S�LME SONRASINDA �A�IRILIR");
	}
}















