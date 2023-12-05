<template>
	<view style="padding: 5px 15px;">
		<view style="padding: 10px 15px;" class="itemInfo" @click="toDetial()">
			<view class="flex flex-bet flex-row-center">
				<view>
					<view class="work-name">
						{{itemInfo.jobTitle}}
					</view>
					<view class="flex flex-row-end tagList">
						<view>
							<u-tag :text="workTime(itemInfo.workTimeStart, itemInfo.workTimeEnd)" color="#1296db" size="mini" plain></u-tag>
						</view>
						<view>
							<u-tag :text="getXueLiLabel(itemInfo.education)" color="#1296db" size="mini" plain></u-tag>
						</view>
						<view>
							<u-tag :text="itemInfo.workPlace" color="#1296db" size="mini" plain></u-tag>
						</view>
					</view>
				</view>
				<view class="xinzi">
					{{wages(itemInfo.wagesStart, itemInfo.wagesEnd)}}
				</view>
			</view>
			<view class="yuan">
				信息来源：{{itemInfo.sourceWebsite == 0 ? "智联招聘" : itemInfo.sourceWebsite == 1 ? "BOSS直聘" : "前程无忧"}}
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		name:"workItem",
		data() {
			return {
				
			};
		},
		props: {
			itemInfo: {
				type: Object,
				default: function(){
					return {}
				}
			},
			xueliArray: {
				type: Array,
				default: function(){
					return []
				}
			}
		},
		methods: {
			workTime(worktimeStart, worktimeEnd){
				let a = worktimeStart + '-' + worktimeEnd + '年';
				return a;
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
				return num.toString();
			  }
			},
			getXueLiLabel(targetId){
				let that = this;
				// console.log(targetId);
				const matchingObject = that.xueliArray.find(item => item.dictValue == targetId);
				// 如果找到匹配的对象，获取其 value 值；否则返回 null 或者自定义的默认值
				const resultValue = matchingObject ? matchingObject.dictLabel : "不限";
				return resultValue;
			},
			toDetial(){
				let that = this;
				uni.navigateTo({
					url: `/pages/index/detial/detial?id=${that.itemInfo.id}`
				})
			},
		}
	}
</script>

<style scoped>
	.flex{
		display: flex;
	}
	.flex-bet{
		justify-content: space-between;
	}
	.flex-row-center{
		align-items: center;
	}
	.flex-row-end{
		align-items: flex-end;
	}
	.itemInfo{
		border-radius: 5px;
		box-shadow: 0 0 2px 3px #e3e3e3;
	}
	.work-name{
		font-weight: bold;
		font-size: 17px;
		margin-right: 10px;
	}
	.tagList{
		margin-top: 10px;
	}
	.tagList > view:not(:first-child){
		margin-left: 8px;
	}
	.xinzi{
		font-weight: bold;
		font-size: 15px;
		color: #1296db;
		letter-spacing: 1px;
		white-space: nowrap;
	}
	.yuan{
		margin-top: 5px;
		font-size: 14px;
		color: #909090;
		text-align: right;
	}
</style>