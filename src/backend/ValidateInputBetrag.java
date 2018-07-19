package backend;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;


public class ValidateInputBetrag {

	public ValidateInputBetrag() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//BlockChain has to be created and started before
		MultiChainCommand test = new MultiChainCommand("192.168.1.4", "6760", "multichainrpc","8U7rf5R6TgR6iU5Wm6RJWUX2bFW6GyQ718MwB268GQGh");

		// localhost is the IP used by Multichain
		// 6824 is, here, the port used by the BlockChain, corresponding of the value of default-rpc-port in the file params.dat 
		// multichainrpc and 73oYQWzx45h... are login and password to access to RPC commands, values can be found in the file multichain.conf

		List<String> result = null;
		try {
			result = test.getAddressCommand().getAddresses();
			System.out.println(result);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//result contains the addresses of the wallet as list of String.

	}

}
