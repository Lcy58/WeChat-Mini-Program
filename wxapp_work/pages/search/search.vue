<template>
	<view>
		<u-navbar
			title="查询"
			:autoBack="false"
			leftIconSize="0"
			:placeholder="true"
			bgColor="#1296db"
			:titleStyle="{color: '#fff', fontWeight: 'bold'}"
		>
			<!-- <view slot="right" @click="more">
				<u-icon name="list" size="22" bold color="#fff"></u-icon>
			</view> -->
		</u-navbar>
		<view>
			<!-- 公司  职位   ----  专业  学历 -->
			<view>
				<view style="padding: 15px 20px 6px 20px;">
					<u-search 
						placeholder="请输入职位信息" 
						:focus="true"
						:actionStyle="{
							fontWeight: 'bold'
						}"
						@search="searchKey"
						@custom="searchKey"
						v-model="params.jobTitle">
					</u-search>
				</view>
			</view>
			
			<view class="getMore">
				<view>
					<u-tag @click="more" 
					:text="params.studyMajor === '' ? '筛选专业' : getDictLabel(zhuanyeList ,params.studyMajor)" 
					size="mini" plain shape="circle"></u-tag>
				</view>
				<view>
					<u-tag @click="more" 
					:text="params.education === '' ? '筛选学历' : getDictLabel(xueliList ,params.education)" 
					size="mini" plain shape="circle"></u-tag>
				</view>
				<view>
					<u-tag @click="more" text="更多" size="mini" plain shape="circle"></u-tag>
				</view>
			</view>
			
			<u-popup :show="moreShow" 
				@close="moreShow = false"
				mode="right"
				 @open="moreShow = true"
				 >
				<view style="padding: 15px; width: 260px;">
					
					<view class="moreTile">学历</view>
					<view class="moreListData">
						<view v-for="(item, index) in xueliList"
						:key="index" @click="changeXueli(item)"
						:style="{backgroundColor: (params.education == item.dictValue ? '#1296DB' : '#fff'),
								color: (params.education == item.dictValue ? '#fff' : '#1296DB')
						}">
							{{item.dictLabel}}
						</view>
					</view>
					
					<view style="margin-top: 30px;" class="moreTile">专业</view>
					<view class="moreListData">
						<view v-for="(item, index) in zhuanyeList"
						:key="index" @click="changeZhuanye(item)"
						:style="{backgroundColor: (params.studyMajor == item.dictValue ? '#1296DB' : '#fff'),
								color: (params.studyMajor == item.dictValue ? '#fff' : '#1296DB')
						}"
						>
							{{item.dictLabel}}
						</view>
					</view>
					
				</view>
			</u-popup>

			<view>
				<workItem 
					v-for="(item, index) in workList" 
					:key="index"
					:itemInfo="item" 
					:xueliArray="xueliList"
				></workItem>
			</view>
			
		</view>
		<tabbarCom :current="2"></tabbarCom>
	</view>
</template>

<script>
	import tabbarCom from "../../components/tabbar/tabbar.vue"
	import workItem from "../../components/workItem/workItem.vue"
	import { getDictData, getSearchWorkList } from "../../config/api.js"
	export default {
		data() {
			return {
				searchVal: "",
				moreShow: false,
				workList: [],
				xueliList: [],
				zhuanyeList: [],
				params: {
					"jobTitle": "",
					"education": "",
					"studyMajor": "",
					"pageSizeApi": 1,
					"pageNumApi": 50
				}
			}
		},
		components: {
			tabbarCom,
			workItem
		},
		onLoad() {
			let that = this;
			// 学历
			getDictData("tb_education").then(res => {
				that.xueliList = res.data;
			})
			// 专业
			getDictData("tb_major").then(res => {
				that.zhuanyeList = res.data;
			})
		},
		onReachBottom(){
			// console.log("触底");
			let that = this;
			that.params.pageSizeApi += 1;
			that.getSearchList();
		},
		methods: {
			more(){
				let that = this;
				this.moreShow = true;
			},
			searchKey(){
				let that = this;
				if(!that.params.jobTitle){
					uni.$u.toast("请填写职位信息");
				}
				that.workList = [];
				getSearchWorkList(that.params).then(res => {
					if(res.data.length == 0){
						uni.$u.toast("没有查询到"+ that.params.jobTitle +"相关的职业！");
						return
					}
					that.workList = res.data;
				})
			},
			getSearchList(){
				let that = this;
				getSearchWorkList(that.params).then(res => {
					that.workList = that.workList.concat(res.data);
				})
			},
			changeXueli(e){
				let that = this;
				if(e.dictValue == that.params.education){
					that.params.education = "";
					return
				}
				that.params.education = e.dictValue;
			},
			changeZhuanye(e){
				let that = this;
				if(e.dictValue == that.params.studyMajor){
					that.params.studyMajor = "";
					return
				}
				that.params.studyMajor = e.dictValue;
			},
			getDictLabel(arrayInfo, targetId){
				let that = this;
				// console.log(targetId);
				const matchingObject = arrayInfo.find(item => item.dictValue == targetId);
				// 如果找到匹配的对象，获取其 value 值；否则返回 null 或者自定义的默认值
				const resultValue = matchingObject ? matchingObject.dictLabel : "不限";
				return resultValue;
			},
		}
	}
</script>

<style scoped>
	.getMore{
		display: flex; 
		align-items: center; 
		padding: 2px 20px;
	}
	.getMore>view:not(:first-child){
		margin-left: 10px;
	}
	.moreTile{
		font-weight: bold;
		padding: 15px 0 10px 0;
		font-size: 17px;
		letter-spacing: 1px;
		color: #6b6b6b;
	}
	
	.moreListData{
		display: flex;
		flex-wrap: wrap;
	}
	.moreListData view{
		padding: 2px 7px;
		border: 1px solid #1296DB;
		border-radius: 4px;
		font-size: 14px;
		margin-left: 10px;
		margin-top: 12px;
		color: #1296DB;
	}
</style>
