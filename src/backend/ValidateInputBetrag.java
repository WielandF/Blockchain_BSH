package backend;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import frontend.LoginFrontend;;

public class ValidateInputBetrag {



	
	public ValidateInputBetrag() {
		// TODO Auto-generated constructor stub
	
	}

	public void callBlockchain(String name, String pw) {
		//BlockChain has to be created and started before  "multichainrpc"
		MultiChainCommand test = new MultiChainCommand("192.168.1.4", "6802", name, pw);

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
	
	
	public static void main(String[] args) {


	}

}
