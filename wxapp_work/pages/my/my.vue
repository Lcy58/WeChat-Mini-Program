<template>
	<view>
		<u-navbar
			title="我的"
			:autoBack="false"
			leftIconSize="0"
			:placeholder="true"
			bgColor="#1296db"
			:titleStyle="{color: '#fff', fontWeight: 'bold'}"
		>
		</u-navbar>
		<view style="padding: 30px;">
			<view v-if="userInfo.id == 0">
				<view style="margin-top: 120px;" @click="getUserInfo">
					<view style="text-align: center;">
						<image src="../../static/avater.png" class="headImg" mode=""></image>
					</view>
					<view style="font-weight: bold; 
					font-size: 17px; 
					text-align: center;
					margin-top: 10px;">
						点击登录
					</view>
				</view>
			</view>
			<view v-else-if="userInfo.userName">
				<view style="text-align: center; margin-top: 120px;">
					<image 
					src="../../static/avater.png" 
					style="width: 80px; height: 80px;"
					mode=""></image>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>姓名:</view>
					<view>{{userInfo.userName}}</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>学历:</view>
					<view>
						<view v-for="(item, index) in xueliList"
						:key="index" v-if="item.dictValue == userInfo.education"
						>
							{{item.dictLabel}}
						</view>
					</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>工作经验:</view>
					<view>{{userInfo.workTime}}年</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>所学专业:</view>
					<view>
						<view v-for="(item, index) in zhuanyeList"
						:key="index" v-if="item.dictValue == userInfo.studyMajor"
						>
							{{item.dictLabel}}
						</view>
					</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>期望薪资:</view>
					<view>{{userInfo.wagesStart}}-{{userInfo.wagesEnd}}</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>联系电话:</view>
					<view>{{userInfo.callPhone}}</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>期望工作地点:</view>
					<view>{{userInfo.workPlace}}</view>
				</view>
				
				<view class="flex flex-row-center flex-center mg-top-10 item-info">
					<view>毕业院校:</view>
					<view>{{userInfo.gradSchool}}</view>
				</view>
				
				<view style="display: flex; justify-content: center; align-items: center;
				margin-top: 20px;
				">
					<view>
						<u-button @click="editUserInfo" color="#1296db" text="修改信息"></u-button>
					</view>
					<view style="margin-left: 25px;">
						<u-button @click="loginOut" type="error" text="退出登录"></u-button>
					</view>
				</view>
			</view>
			
			
	
			<u-overlay :show="show" opacity="0.7">
				
				<view
				style="
					background-color: #fff;
					width: 86%; margin: 60px auto 0 auto;
					padding: 15px;
					border-radius: 10px;
				">
				<view style="text-align: center; font-weight: bold;">请完善个人信息</view>
					<u--form
						labelPosition="left"
						labelWidth="75"
						:model="userInfo"
						:rules="rules"
						ref="uForm"
					>
					
					<u-form-item
						label="姓名:"
						prop="userName"
						borderBottom
						required
						ref="item1"
					>
						<u--input
							v-model="userInfo.userName"
							placeholder="请输入姓名"
							border="none"
						></u--input>
					</u-form-item>
					
					<u-form-item
						label="学历:"
						prop="education"
						borderBottom
						@click="selXueli"
						required
						ref="item1"
					>
						<u--input
							:disabled="true"
							disabledColor="#fff"
							v-model="selXueliLabel"
							placeholder="请选择学历"
							border="none"
						></u--input>
					</u-form-item>
					
					<u-form-item
						label="工作经验:"
						prop="workTime"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="userInfo.workTime"
							placeholder="请输入工作时长"
							border="none"
						>
							<template slot="suffix">
								年
							</template>				
						</u--input>
					</u-form-item>
					
					<u-form-item
						label="所学专业:"
						prop="studyMajor"
						required
						@click="selZhuanye"
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="selZhuanyeLabel"
							placeholder="请选择所学专业"
							:disabled="true"
							disabledColor="#fff"
							border="none"
						></u--input>
					</u-form-item>
					
					<u-form-item
						label="最低薪资:"
						prop="wagesStart"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							placeholder="请输入期望的最低薪资"	
							v-model="userInfo.wagesStart"
							border="none"
						>
							<template slot="suffix">
								元
							</template>		
						</u--input>
					</u-form-item>
					
					<u-form-item
						label="最高薪资:"
						prop="wagesEnd"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="userInfo.wagesEnd"
							placeholder="请输入期望的最高薪资"	
							border="none"
						>
							<template slot="suffix">
								元
							</template>	
						</u--input>
					</u-form-item>
					
					<u-form-item
						label="联系电话:"
						prop="callPhone"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="userInfo.callPhone"
							placeholder="请输入自己的联系电话"	
							border="none"
						></u--input>
					</u-form-item>
					
					<u-form-item
						label="期望地点:"
						prop="workPlace"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="userInfo.workPlace"
							placeholder="请输入自己的期望的工作地点"	
							border="none"
						></u--input>
					</u-form-item>
					
					<u-form-item
						label="毕业院校:"
						prop="gradSchool"
						required
						borderBottom
						ref="item1"
					>
						<u--input
							v-model="userInfo.gradSchool"
							placeholder="请输入自己的毕业院校"
							border="none"
						></u--input>
					</u-form-item>
					
					</u--form>
					
					<view style="width: 50%;
					margin: 20px auto 5px auto;
					">
						<u-button text="提交信息" @click="insUser" color="#1296db"></u-button>
					</view>
				</view>
			</u-overlay>
			
			
			
		</view>
		
		<u-picker
			:show="pickerShow" 
			:columns="columns"
			keyName="dictLabel"
			@close="pickerShow = false"
			@confirm="selDataInfo"
			@cancel="pickerShow = false"
			>
		</u-picker>
		
		<tabbarCom :current="3"></tabbarCom>
	</view>
</template>

<script>
	import tabbarCom from "../../components/tabbar/tabbar.vue"
	import { getCode, insUser, getDictData, editUser } from "../../config/api.js"
	export default {
		data() {
			return {
				show: false,
				pickerShow: false,
				// 0 学历  1 专业
				pickerType: 0,
				selXueliLabel: "",
				selZhuanyeLabel: "",
				columns: [],
				xueliList: [],
				zhuanyeList: [],
				userInfo: {
					callPhone: "",
					education: "",
					gradSchool: "",
					id: 0,
					openId: "",
					remark: "",
					studyMajor: "",
					userName: "",
					wagesEnd: "",
					wagesStart: "",
					workPlace: "",
					workTime: "",
				},
				rules:{
					'username': {
						type: 'string',
						required: true,
						message: '请输入姓名',
						trigger: ['blur', 'change']
					},
					'workTime': {
						type: 'string',
						required: true,
						message: '请输入工作时长',
						trigger: ['blur', 'change']
					},
					'wagesStart': {
						type: 'string',
						required: true,
						message: '请输入期望的最低薪资',
						trigger: ['blur', 'change']
					},
					'wagesEnd': {
						type: 'string',
						required: true,
						message: '请输入期望的最高薪资',
						trigger: ['blur', 'change']
					},
					'callPhone': {
						type: 'string',
						required: true,
						message: '请输入自己的联系电话',
						trigger: ['blur', 'change']
					},
					'workPlace': {
						type: 'string',
						required: true,
						message: '请输入自己的期望的工作地点',
						trigger: ['blur', 'change']
					},
					'gradSchool': {
						type: 'string',
						required: true,
						message: '请输入自己的毕业院校',
						trigger: ['blur', 'change']
					},
				}
			}
		},
		components: {
			tabbarCom
		},
		onLoad() {
			let that = this;
			let getUserInfo = uni.getStorageSync("userInfo");
			if(getUserInfo){
				this.userInfo = getUserInfo;
			}
			
			// 学历
			getDictData("tb_education").then(res => {
				that.xueliList = res.data;
			})
			
			// 专业
			getDictData("tb_major").then(res => {
				that.zhuanyeList = res.data;
			})
		},
		methods: {
			editUserInfo(){
				let that = this;
				that.show = true;
			},
			loginOut(){
				let that = this;
				uni.removeStorageSync('userInfo');
				uni.reLaunch({
					url: '/pages/my/my'
				});
			},
			getUserInfo(){
				let that = this;
				uni.login({
					"provider": "weixin",
					"onlyAuthorize": true, 
					success: function(event){
						const {code} = event
						getCode(code).then(res => {
							if(res.data.userName){
							// username 有值  用户绑定过  直接吧res.data赋值
								that.userInfo = res.data;
								uni.setStorageSync("userInfo", res.data)
							}else{
								that.userInfo.openId = res.data.openId;
								uni.$u.toast("微信授权成功！请完善个人信息");
								that.show = true;
								setTimeout(function(){
									that.$refs.uForm.setRules(that.rules)
								}, 500)
							}
						})
					},
					fail: function (err) {
						// 登录授权失败  
						// err.code是错误码
						console.log("授权错误", err);
					}
				})
			},
			insUser(){
				let that = this;
				if(that.userInfo.id != 0){
					editUser(that.userInfo).then(res => {
						console.log("进入 修改");
						uni.setStorageSync("userInfo", res.data)
						that.userInfo = res.data;
						that.show = false;
					})
				}else{
					console.log("进入添加");
					this.$refs.uForm.validate().then(res => {
						insUser(that.userInfo).then(res => {
							uni.setStorageSync("userInfo", res.data)
							that.userInfo = res.data;
							that.show = false;
						})
					}).catch(errors => {
						uni.$u.toast('请检查填写数据')
					})
				}
				
			},
			selXueli(){
				let that = this;
				that.columns = [];
				that.columns.push(that.xueliList);
				that.pickerShow = true;
				that.pickerType = 0;
				
			},
			selZhuanye(){
				let that = this;
				that.columns = [];
				that.columns.push(that.zhuanyeList);
				that.pickerShow = true;
				that.pickerType = 1;
			},
			selDataInfo(e){
				let that = this;
				if(that.pickerType == 0){
					that.selXueliLabel = e.value[0].dictLabel;
					that.userInfo.education = e.value[0].dictValue;
				}else{
					that.selZhuanyeLabel = e.value[0].dictLabel;
					that.userInfo.studyMajor = e.value[0].dictValue;
				}
				that.pickerShow = false;
			},
			
		}
	}
</script>

<style scoped>
	.item-info>view:nth-child(1){
		font-weight: bold;
	}
	.item-info>view:nth-child(2){
		margin-left: 12px;
		color: #585858;
		letter-spacing: 1px;
	}
	.mg-top-10{
		margin-top: 10px;
	}
	.flex{
		display: flex;
	}
	.flex-center{
		justify-content: center;
	}
	.flex-bet{
		justify-content: space-between;
	}
	.flex-row-center{
		align-items: center;
	}
	.headImg{
		width: 60px;
		height: 60px;
		border-radius: 50%;
	}
</style>
