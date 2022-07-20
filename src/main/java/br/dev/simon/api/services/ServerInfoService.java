package br.dev.simon.api.services;

import java.io.File;
import java.lang.management.ManagementFactory;

import org.springframework.stereotype.Service;

import com.sun.management.OperatingSystemMXBean;

import br.dev.simon.api.response.ServerInfoResponse;

@Service
public class ServerInfoService {

	public ServerInfoResponse showServerInfo() {

		ServerInfoResponse response = new ServerInfoResponse();
		StringBuilder mensagem = new StringBuilder();

		try {
			int mb = 1024 * 1024;
			int gb = 1024 * 1024 * 1024;

			OperatingSystemMXBean osMXB = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			long memoriaRamTotal = osMXB.getTotalPhysicalMemorySize();
			long memoriaRamLivre = osMXB.getFreePhysicalMemorySize();

			response.setRamTotal(memoriaRamTotal / mb);
			response.setRamLivre(memoriaRamLivre / mb);
			response.setRamUsada((memoriaRamTotal - memoriaRamLivre) / mb);

			File disco = new File("/dev/xvda3");

			double discoCapacidadeTotal = disco.getTotalSpace() / gb;
			double discoEspacoLivre = disco.getFreeSpace() / gb;

			response.setDiscoTotal(discoCapacidadeTotal);
			response.setDiscoLivre(discoEspacoLivre);
			response.setDiscoUsado(discoCapacidadeTotal - discoEspacoLivre);

			if (discoEspacoLivre <= discoCapacidadeTotal % 10) {
				mensagem.append("Pouco espaço em disco!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setMensagem(mensagem.toString());
		return response;
	}
}
