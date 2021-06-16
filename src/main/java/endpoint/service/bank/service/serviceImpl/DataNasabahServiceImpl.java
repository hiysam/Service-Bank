package endpoint.service.bank.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import endpoint.service.bank.dto.DataNasabahDto;
import endpoint.service.bank.entity.DataNasabah;
import endpoint.service.bank.repository.DataNasabahRepository;
import endpoint.service.bank.service.DataNasabahService;

@Service
public class DataNasabahServiceImpl implements DataNasabahService{

	@Autowired
	private DataNasabahRepository nasabahRepository;
	
	@Override
	public void regisNasabah(DataNasabahDto dto) {
		// TODO Auto-generated method stub
		DataNasabah nasabah = new DataNasabah();
		nasabah.setUsername(dto.getUsername().toLowerCase());
		nasabah.setSaldo(dto.getSaldo());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try {
			nasabah.setCreateDate(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nasabahRepository.save(nasabah);
	}

	@Override
	public int findByUsername(String username) {
		// TODO Auto-generated method stub
		int jumlahData = nasabahRepository.finByUsername(username);
		return jumlahData;
	}

	@Override
	public int checkSaldo(String username) {
		// TODO Auto-generated method stub
		int saldo = nasabahRepository.findSaldo(username);
		return saldo;
	}

}
