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
import multichain.object.StreamKeyItem;
import frontend.LoginFrontend;

public class ValidateInputBetrag {
	
	public MultiChainCommand multiChainCommand;


	
	public ValidateInputBetrag() {
		// TODO Auto-generated constructor stub
	
	}

	public void callBlockchain(String name, String pw, String betrag) {
		//BlockChain has to be created and started before  "multichainrpc"
		if(multiChainCommand == null) {
			multiChainCommand = new MultiChainCommand("192.168.1.4", "4414", name, pw);
		}
		List<String> result = null;
		try {
			
			if (betrag != "") {
				JSONObject obj = new JSONObject();
				
			      try {
				    obj.put("value", betrag);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			    System.out.print(obj);
				StreamCommand streamcommand = multiChainCommand.getStreamCommand();
				streamcommand.publish("hackstream1", "FSA", betrag);
			}
			
			
			result = multiChainCommand.getAddressCommand().getAddresses();
			System.out.println(result);
			
			
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String readBlockchain(String name, String pw) {
		
		if(multiChainCommand == null) {
			multiChainCommand = new MultiChainCommand("192.168.1.4", "4414", name, pw);
		}
		
		String s = "";
		
		StreamCommand streamcommand = multiChainCommand.getStreamCommand();
		try {
			List<StreamKeyItem> fsalist = streamcommand.listStreamKeyItems("hackstream1", "FSA");
			System.out.println(fsalist);
			
			for (StreamKeyItem s1 : fsalist)
			{
			    s = s1.getData();
			}

		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
		
		
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
