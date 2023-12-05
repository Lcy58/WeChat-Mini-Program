<template>
	<view>
		<u-navbar
			title="职位详情"
			:autoBack="true"
			leftIconColor="#fff"
			:placeholder="true"
			bgColor="#1296db"
			:titleStyle="{color: '#fff', fontWeight: 'bold'}"
		>
		</u-navbar>
		<view>
			
			<view style="padding: 15px;">
				<!-- 头部介绍 -->
				<view>
					<view class="flex flex-between flex-row-center">
						<view style="font-size: 18px; font-weight: bold;margin-right: 10px;">
							{{workInfo.jobTitle}}
						</view>
						<view class="xinzi">
							{{wages(workInfo.wagesStart, workInfo.wagesEnd)}}
						</view>
					</view>
					
					<view class="flex flex-between flex-row-end">
						<view class="flex flex-row-end tagList">
							<view>
								<u-tag :text="workTime(workInfo.workTimeStart, workInfo.workTimeEnd)" color="#1296db" size="mini" plain></u-tag>
							</view>
							<view>
								<u-tag :text="getXueLiLabel(workInfo.education)" color="#1296db" size="mini" plain></u-tag>
							</view>
							<view>
								<u-tag :text="workInfo.workPlace" color="#1296db" size="mini" plain></u-tag>
							</view>
						</view>
						<view class="yuan">
							信息来源：{{workInfo.sourceWebsite == 0 ? "智联招聘" : workInfo.sourceWebsite == 1 ? "BOSS直聘" : "前程无忧"}}
						</view>
					</view>
					
				</view>
				<!-- 分割线 -->
				<u-line color="#c5c5c5" margin="15px 0"></u-line>
				<!-- hr  公司名-->
				<view class="flex flex-row-center">
					<view>
						<u-avatar :src="workInfo.hrImg" size="65"></u-avatar>
					</view>
					<view style="margin-left: 15px;">
						<view>我是HR</view>
						<view style="font-size: 15px; 
						color: #aaaaaa; margin-top: 6px;">{{workInfo.companyName}}</view>
					</view>
				</view>
				
				<!-- 分割线 -->
				<u-line color="#c5c5c5" margin="15px 0"></u-line>
				<!-- 任职要求 -->
				<view>
					<view style="font-weight: bold; font-size: 17px;">
						任职要求:
					</view>
					<view style="margin-top: 15px;">
						<u-parse :content="workInfo.useRequire" style="line-height: 28px;"></u-parse>
					</view>
				</view>
			</view>
			
		</view>
	</view>
</template>

<script>
	import { getWorkById, getDictData } from "../../../config/api.js"
	export default {
		data() {
			return {
				xueliList: [],
				workInfo: {}
			}
		},
		onLoad(option) {
			if(!option.id){
				uni.switchTab({
					url: "/pages/index/index"
				})
			}
			this.getWorkInfoById(option.id);
			this.getXueliList();
		},
		methods: {
			getWorkInfoById(id){
				let that = this;
				getWorkById(id).then(res => {
					console.log(res.data);
					that.workInfo = res.data;
				})
			},
			workTime(worktimeStart, worktimeEnd){
				let a = worktimeStart + '-' + worktimeEnd + '年';
				return a;
			},
			getXueLiLabel(targetId){
				let that = this;
				// console.log(targetId);
				const matchingObject = that.xueliList.find(item => item.dictValue == targetId);
				// 如果找到匹配的对象，获取其 value 值；否则返回 null 或者自定义的默认值
				const resultValue = matchingObject ? matchingObject.dictLabel : "不限";
				return resultValue;
			},
			getXueliList(){
				let that = this;
				getDictData("tb_education").then(res => {
					that.xueliList = res.data;
				})
			},
			wages(wagesStart, wagesEnd){
				let that = this;
				let a = that.formatNumber(wagesStart) + '-' + that.formatNumber(wagesEnd);
				return a;
			},
			formatNumber(num) {
			  if (num >= 10000) {
				const wValue = (num / 10000).toFixed(1);
				return `${wValue}w`;
			  } else if (num >= 1000) {
				const kValue = (num / 1000).toFixed(0);
				return `${kValue}k`;
			  } else {
				return num;
			  }
			},
		}
	}
</script>

<style scoped>
	.flex{
		display: flex;
	}
	.flex-between{
		justify-content: space-between;
	}
	.flex-row-center{
		align-items: center;
	}
	.flex-row-end{
		align-items: flex-end;
	}
	.tagList{
		margin-top: 10px;
	}
	.tagList > view:not(:first-child){
		margin-left: 8px;
	}
	.xinzi{
		font-weight: bold;
		font-size: 17px;
		color: #1296db;
		letter-spacing: 1px;
		white-space: nowrap;
	}
	.yuan{
		margin-top: 5px;
		font-size: 14px;
		color: #909090;
	}
</style>
