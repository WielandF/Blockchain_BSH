package backend;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import multichain.command.BlockCommand;
import multichain.command.ChainCommand;
import multichain.command.IssueCommand;
import multichain.command.KeyCommand;
import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.command.StreamCommand;
import multichain.command.WalletTransactionCommand;
import multichain.object.BalanceAsset;
import frontend.LoginFrontend;

public class ValidateInputBetrag {
	
	public MultiChainCommand multiChainCommand;


	
	public ValidateInputBetrag() {
		// TODO Auto-generated constructor stub
	
	}

	public void callBlockchain(String name, String pw, String betrag) {
		//BlockChain has to be created and started before  "multichainrpc"
		multiChainCommand = new MultiChainCommand("192.168.1.4", "4414", name, pw);
	
		// localhost is the IP used by Multichain
		// 6824 is, here, the port used by the BlockChain, corresponding of the value of default-rpc-port in the file params.dat 
		// multichainrpc and 73oYQWzx45h... are login and password to access to RPC commands, values can be found in the file multichain.conf
		//System.out.print(name);
		//System.out.print(pw);
		//System.out.print(betrag);
		List<String> result = null;
		try {
			
			if (betrag != "") {
				JSONObject obj = new JSONObject();
				
			      try {
				//	obj.put("name", name);
					//obj.put("pw", pw);
				    obj.put("value", betrag);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			    System.out.print(obj);
				StreamCommand streamcommand = multiChainCommand.getStreamCommand();
//				streamcommand.publish("hackstream1", "FSA", betrag.toString());
				streamcommand.publish("hackstream1", "FSA", betrag);
				//streamcommand.publish(streamName, key, dataHex)
			}
			
			
			result = multiChainCommand.getAddressCommand().getAddresses();
			System.out.println(result);
			
			
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//result contains the addresses of the wallet as list of String.
	}
	
	public void publishFSA(String name, String pw) {
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		MultiChainCommand test = new MultiChainCommand("192.168.1.4", "4414", "multichainrpc", "Csh4eMi3s9r4yVQ1CY2RtrF8uduhiojJBi1ASNUGKwpM");

		// localhost is the IP used by Multichain
		// 6824 is, here, the port used by the BlockChain, corresponding of the value of default-rpc-port in the file params.dat 
		// multichainrpc and 73oYQWzx45h... are login and password to access to RPC commands, values can be found in the file multichain.conf

		List<String> result = null;
		try {
			
			
			StreamCommand streamcommand = test.getStreamCommand();
//			IssueCommand result3 = test.getIssueCommand();
//			result3.issue("1EQ8FHj3gs5qMhnfeJjJdsqAzKkhq1tHeH5Not", "Euro", 200, 0,01);
//			test.setIssueCommand(result3);
//			result2.subscribe("stream1");
//			test.setStreamCommand(result2);
//			WalletTransactionCommand test2134 = test.getWalletTransactionCommand();

//			List<BalanceAsset> result5 = test.getBalanceCommand().getTotalBalances();
//			System.out.println(result5);
			
			//streamcommand.publish("hackstream1", "FSA", "96");

			
			result = test.getAddressCommand().getAddresses();
			System.out.println(result);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
