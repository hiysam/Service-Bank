package endpoint.service.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import endpoint.service.bank.dto.DataNasabahDto;
import endpoint.service.bank.dto.TransaksiDto;
import endpoint.service.bank.service.DataNasabahService;
import endpoint.service.bank.service.TransaksiService;

@RestController
@RequestMapping(value = "/bank")
public class ApiServiceBank {
	
	@Autowired
	private DataNasabahService nasabahService;
	
	@Autowired
	private TransaksiService transService;
	
	@PostMapping(value = "regisNasabah")
	public void regisNasabah(@RequestBody DataNasabahDto dto, HttpServletResponse json) throws IOException {
		JSONObject response = new JSONObject();
		if(!dto.getUsername().trim().isEmpty() && dto.getSaldo() > 0) {
			int count = nasabahService.findByUsername(dto.getUsername().toLowerCase());
			if(count > 0) {
				response.put("ResponseCode", "02");
				response.put("ResponseDescription", "Maaf Username sudah terdafar");
			} else {
				nasabahService.regisNasabah(dto);
				response.put("ResponseCode", "00");
				response.put("ResponseDescription", "Success Registration");
				response.put("saldo", dto.getSaldo());
			}
		} else {
			response.put("ResponseCode", "01");
			response.put("ResponseDescription", "Ada field yang kosong atau saldo tidak boleh 0 ataupun mines");
		}
		
		json.setContentType("application/json");
		PrintWriter out = json.getWriter();
		out.print(response.toString());
		out.flush();
	}
	
	@PostMapping(value = "addBalance")
	public void addSaldo(@RequestBody TransaksiDto dto, HttpServletResponse json) throws IOException {
		JSONObject response = new JSONObject();
		if(!dto.getUsername().trim().isEmpty() && dto.getNominal() > 0) {
			int count = nasabahService.findByUsername(dto.getUsername().toLowerCase());
			if(count > 0) {
				int totalSaldo = transService.addSaldo(dto);
				response.put("ResponseCode", "00");
				response.put("ResponseDescription", "Add Balance Success");
				response.put("TotalSaldo", totalSaldo);
			} else {
				response.put("ResponseCode", "02");
				response.put("ResponseDescription", "Maaf username tidak ditemukan, masukan username dengan benar");
			}
		} else {
			response.put("ResponseCode", "01");
			response.put("ResponseDescription", "Ada field yang kosong atau nominal tidak boleh 0 ataupun mines");
		}
		
		json.setContentType("application/json");
		PrintWriter out = json.getWriter();
		out.print(response.toString());
		out.flush();
	}
	
	@PostMapping(value = "transferBalance")
	public void transferBalance(@RequestBody TransaksiDto dto, HttpServletResponse json) throws IOException {
		JSONObject response = new JSONObject();
		if(!dto.getUsername().trim().isEmpty() && !dto.getUsernameTujuan().trim().isEmpty() && dto.getNominal() > 0) {
			if(!dto.getUsername().toLowerCase().equals(dto.getUsernameTujuan().toLowerCase())) {
				int countUsername = nasabahService.findByUsername(dto.getUsername().toLowerCase());
				int countUsernameTujuan = nasabahService.findByUsername(dto.getUsernameTujuan().toLowerCase());
				if(countUsername > 0 && countUsernameTujuan > 0) {
					int transfer = transService.findTransferToDay(dto);
					int limit = transfer + dto.getNominal();
					System.out.println("Total : "+transfer);
					if(transfer <= 50000 && limit <= 50000) {
						System.out.println("nominal : "+dto.getNominal());
						int saldo = nasabahService.checkSaldo(dto.getUsername());//nasabahService.transfer(dto);
						if(saldo < dto.getNominal()) {
							response.put("ResponseCode", "05");
							response.put("ResponseDescription", "Maaf saldo Anda tidak mencukupi");
							response.put("saldo", saldo);
						} else {
							int sisaSaldo = transService.transfer(dto);
							response.put("ResponseCode", "00");
							response.put("ResponseDescription", "Success melakukan Transfer");
							response.put("UsernamePenerima", dto.getUsernameTujuan());
							response.put("NominalTransfer", dto.getNominal());
							response.put("Saldo", sisaSaldo);
						}
					} else {
						response.put("ResponseCode", "04");
						response.put("ResponseDescription", "Maaf Transaksi per hari hanya 50000");
						response.put("TotalTf", limit);
					}
				} else {
					response.put("ResponseCode", "03");
					response.put("ResponseDescription", "Username atau username tujuan tidak terdaftar");
				}
			} else {
				response.put("ResponseCode", "02");
				response.put("ResponseDescription", "Username & username tujuan tidak boleh sama");
			}
		} else {
			response.put("ResponseCode", "01");
			response.put("ResponseDescription", "Ada field yang kosong atau nominal tidak boleh 0 ataupun mines");
		}
		json.setContentType("application/json");
		PrintWriter out = json.getWriter();
		out.print(response.toString());
		out.flush();
	}
}
