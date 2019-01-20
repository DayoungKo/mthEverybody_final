package com.teamb.mth.data;

import java.sql.Timestamp;
import java.util.Date;

import com.teamb.mth.vo.BrandVO;
import com.teamb.mth.vo.ConvenVO;
import com.teamb.mth.vo.ItemTypeVO;
import com.teamb.mth.vo.ItemVO;
import com.teamb.mth.vo.MemberVO;
import com.teamb.mth.vo.ProdVO;
import com.teamb.mth.vo.StateVO;


public class ProdRegisterData {
	private ProdVO prodVO;
	private ItemVO itemVO;
	private MemberVO memberVO;
	private ConvenVO convenVO;
	private BrandVO brandVO;
	private ItemTypeVO itemTypeVO;
	private StateVO stateVO;
	private Timestamp prod_timeExdate;
	private Date date;
	
	public ProdRegisterData() {
		super();
	}

	public ProdRegisterData(ProdVO prodVO, ItemVO itemVO, MemberVO memberVO, ConvenVO convenVO, BrandVO brandVO,
			ItemTypeVO itemTypeVO, StateVO stateVO, Date date) {
		super();
		this.prodVO = prodVO;
		this.itemVO = itemVO;
		this.memberVO = memberVO;
		this.convenVO = convenVO;
		this.brandVO = brandVO;
		this.itemTypeVO = itemTypeVO;
		this.stateVO = stateVO;
		this.date = date;
	}

	public ProdRegisterData(ProdVO prodVO,Timestamp prod_timeExdate) {
		super();
		this.prodVO = prodVO;
		this.prod_timeExdate = prod_timeExdate;
	}



	public ProdRegisterData(ProdVO prodVO, ItemVO itemVO, MemberVO memberVO, ConvenVO convenVO, BrandVO brandVO,
			ItemTypeVO itemTypeVO, StateVO stateVO) {
		super();
		this.prodVO = prodVO;
		this.itemVO = itemVO;
		this.memberVO = memberVO;
		this.convenVO = convenVO;
		this.brandVO = brandVO;
		this.itemTypeVO = itemTypeVO;
		this.stateVO = stateVO;
	}


	
	
	public ProdVO getProdVO() {
		return prodVO;
	}

	public void setProdVO(ProdVO prodVO) {
		this.prodVO = prodVO;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ConvenVO getConvenVO() {
		return convenVO;
	}

	public void setConvenVO(ConvenVO convenVO) {
		this.convenVO = convenVO;
	}

	public BrandVO getBrandVO() {
		return brandVO;
	}

	public void setBrandVO(BrandVO brandVO) {
		this.brandVO = brandVO;
	}

	public ItemTypeVO getItemTypeVO() {
		return itemTypeVO;
	}

	public void setItemTypeVO(ItemTypeVO itemTypeVO) {
		this.itemTypeVO = itemTypeVO;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public Timestamp getProd_timeExdate() {
		return prod_timeExdate;
	}

	public void setProd_timeExdate(Timestamp prod_timeExdate) {
		this.prod_timeExdate = prod_timeExdate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
