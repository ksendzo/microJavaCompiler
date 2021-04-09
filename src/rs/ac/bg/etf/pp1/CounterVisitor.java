package rs.ac.bg.etf.pp1;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.pp1.ast.*;

public class CounterVisitor extends VisitorAdaptor {
	private int cnt = 0;
	private List<Integer> caseList = new ArrayList<Integer>();
	private int swCnt = 0;
	
	private boolean sameCase = false;
	
	public boolean getSameCase() {
		return sameCase;
	}
	
	public int getCaseNumber() {
		return cnt;
	}
	
	public List<Integer> getCaseValues(){
		return caseList;
	}
	
	public void visit(CaseC c) {
		if(swCnt == 1) {
			cnt++;
			if(caseList.contains(c.getN3()))
				sameCase = true;
			caseList.add(c.getN3());
		}
	}
	
	public void visit(Switch sw) {
		swCnt++;
	}
	
	public void visit(StatementSwitch ss) {
		swCnt--;
	}
}
