package endpoint.service.bank.service;

import endpoint.service.bank.dto.DataNasabahDto;
import endpoint.service.bank.dto.TransaksiDto;

public interface DataNasabahService {

	void regisNasabah(DataNasabahDto dto);

	int findByUsername(String username);

	int checkSaldo(String username);

}
