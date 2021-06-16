package endpoint.service.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import endpoint.service.bank.entity.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long>{

	@Query(value="SELECT SUM(nominal) FROM transaksi WHERE username = :username AND status = 'TF' AND create_transaksi = :today", nativeQuery=true)
	String findTransferToDay(@Param("username") String username, @Param("today") String todayy);

}
