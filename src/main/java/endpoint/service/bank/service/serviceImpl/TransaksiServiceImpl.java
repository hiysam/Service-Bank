package endpoint.service.bank.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import endpoint.service.bank.dto.TransaksiDto;
import endpoint.service.bank.entity.Transaksi;
import endpoint.service.bank.repository.DataNasabahRepository;
import endpoint.service.bank.repository.TransaksiRepository;
import endpoint.service.bank.service.TransaksiService;

@Service
public class TransaksiServiceImpl implements TransaksiService{

	@Autowired
	TransaksiRepository transRepository;
	
	@Autowired
	private DataNasabahRepository nasabahRepository;

	@Override
	public int addSaldo(TransaksiDto dto) {
		// TODO Auto-generated method stub
		Transaksi transaksi = new Transaksi();
		
		transaksi.setUsername(dto.getUsername().toLowerCase());
		transaksi.setStatus("ST");
		transaksi.setUsernameTujuan(dto.getUsername().toLowerCase());
		transaksi.setNominal(dto.getNominal());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try {
			transaksi.setCreateTransaksi(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRepository.save(transaksi);
		
		int saldoAwal = nasabahRepository.findSaldo(dto.getUsername().toLowerCase());
		int totalSaldo = saldoAwal + dto.getNominal();
		nasabahRepository.updateSaldo(totalSaldo, dto.getUsername().toLowerCase());
		
		return totalSaldo;
	}

	@Override
	public int findTransferToDay(TransaksiDto dto) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		String jumlah = transRepository.findTransferToDay(dto.getUsername().toLowerCase(), date);
		int nominal = 0;
		if(jumlah != null) {
			nominal = Integer.valueOf(jumlah);
		}
		return nominal;
	}

	@Override
	public int transfer(TransaksiDto dto) {
		// TODO Auto-generated method stub
		Transaksi transaksi = new Transaksi();
		
		transaksi.setUsername(dto.getUsername().toLowerCase());
		transaksi.setStatus("TF");
		transaksi.setUsernameTujuan(dto.getUsernameTujuan().toLowerCase());
		transaksi.setNominal(dto.getNominal());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try {
			transaksi.setCreateTransaksi(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRepository.save(transaksi);
		
		int sisaSaldo = nasabahRepository.findSaldo(dto.getUsername().toLowerCase());
		sisaSaldo = sisaSaldo - dto.getNominal();
		nasabahRepository.updateSaldo(sisaSaldo, dto.getUsername().toLowerCase());
		
		
		int saldo = nasabahRepository.findSaldo(dto.getUsernameTujuan().toLowerCase());
		saldo = saldo + dto.getNominal();
		nasabahRepository.updateSaldo(saldo, dto.getUsernameTujuan().toLowerCase());
		return sisaSaldo;
	}
}
