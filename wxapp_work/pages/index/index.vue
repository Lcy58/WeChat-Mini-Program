<template>
	<view>
	    <u-navbar
	    	title="首页"
	    	:autoBack="false"
	    	leftIconSize="0"
	    	:placeholder="true"
	    	bgColor="#1296db"
	    	:titleStyle="{color: '#fff', fontWeight: 'bold'}"
	    >
	    </u-navbar>
		<view>
			<!-- banner -->
			<view style="padding-top: 15px;">
				<u-swiper
					:list="bannerList"
					height="150"
					previousMargin="30"
					nextMargin="30"
					circular
					:autoplay="false"
					radius="5"
					bgColor="#ffffff"
				></u-swiper>
			</view>
			<!-- 搜索 -->
			<view style="padding: 12px 26px;">
				<u-search 
					placeholder="搜索更多职位" 
					v-model="keyword"
					:showAction="false"
					:disabled="true"
					@click="goSearch"
				></u-search>
			</view>
			
			<!-- 职位 -->
			<view style="margin-top: 6px;">
				<workItem v-for="(item, index) in workList" :key="index" :itemInfo="item" :xueliArray="xueliList"></workItem>
			</view>

		</view>
		<tabbarCom :current="1"></tabbarCom>
	</view>
</template>

<script>
	import tabbarCom from "../../components/tabbar/tabbar.vue"
	import workItem from "../../components/workItem/workItem.vue"
	import { getWorkList, getDictData } from "../../config/api.js"
	export default {
		data() {
			return {
				bannerList: [
					'/pages/../static/banner1.png',
					'/pages/../static/banner2.png',
					'/pages/../static/banner3.png'
				],
				keyword: "",
				workList: [],
				xueliList: [],
				params: {
					"openId": "asd",
					"pageSize": 1,
					"pageNum": 50
				},
			}
		},
		components: {
			tabbarCom,
			workItem,
		},
		onLoad() {
			this.getXueliList();
			
		},
		onShow() {
			this.workList = [];
			this.getList();
		},
		onReachBottom(){
			// console.log("触底");
			let that = this;
			that.params.pageSize += 1;
			that.getList();
		},
		methods: {
			getList(){
				let that = this;
				let params = that.params;
				let getUserInfo = uni.getStorageSync("userInfo");
				if(getUserInfo){
					params.openId = getUserInfo.openId;
					getWorkList(params).then(res => {
						that.workList = that.workList.concat(res.data);
					})
				}else{
					getWorkList(params).then(res => {
						that.workList = that.workList.concat(res.data);
					})
				}
				

			},
			getXueliList(){
				let that = this;
				getDictData("tb_education").then(res => {
					that.xueliList = res.data;
				})
			},
			goSearch(){
				uni.switchTab({
					url: "/pages/search/search"
				})
			}
		}
	}
</script>

<style>
	
</style>
