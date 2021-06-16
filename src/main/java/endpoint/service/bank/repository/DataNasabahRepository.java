package endpoint.service.bank.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import endpoint.service.bank.entity.DataNasabah;

public interface DataNasabahRepository extends JpaRepository<DataNasabah, Long>{

	@Query(value="SELECT COUNT(username) FROM data_nasabah WHERE username = :username", nativeQuery=true)
	int finByUsername(@Param("username") String username);

	@Query(value="SELECT saldo FROM data_nasabah WHERE username = :username", nativeQuery=true)
	int findSaldo(@Param("username") String username);

	@Transactional
	@Modifying
	@Query(
			value="UPDATE data_nasabah SET "
					+ "saldo = :totalSaldo "
					+ "where username = :username",
			nativeQuery=true)
	void updateSaldo(@Param("totalSaldo") int totalSaldo, @Param("username") String username);

}
