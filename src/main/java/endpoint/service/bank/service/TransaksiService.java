package endpoint.service.bank.service;

import endpoint.service.bank.dto.TransaksiDto;

public interface TransaksiService {

	int addSaldo(TransaksiDto dto);

	int findTransferToDay(TransaksiDto dto);

	int transfer(TransaksiDto dto);

}
