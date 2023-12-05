<template>
	<view>
		<u-tabbar :value="current?current:1" @change="changeTab" :fixed="true"
				  :safeAreaInsetBottom="true" :border="true" :placeholder="true" activeColor="#4E94EC">
			<u-tabbar-item v-for="(item,index) in list" :key="index" :name="item.id" :text="item.text">
				<image class="u-page__item__slot-icon" slot="active-icon" :src="item.selectedIconPath"></image>
				<image class="u-page__item__slot-icon-index" slot="inactive-icon" :src="item.iconPath"></image>
			</u-tabbar-item>
		</u-tabbar>
	</view>
</template>

<script>
	export default {
		name:"tabbar",
		data() {
			return {
				list: [
					{
						id: 1,
						selectedIconPath: "../../static/tabbarImg/tab-sel-1.png",
						iconPath: "../../static/tabbarImg/tab-1.png",
						text: '首页',
						pagePath: "pages/index/index"
					},
					{
						id: 2,
						selectedIconPath: "../../static/tabbarImg/tab-sel-2.png",
						iconPath: "../../static/tabbarImg/tab-2.png",
						text: '搜索',
						pagePath: "pages/search/search"
					},
					{
						id: 3,
						selectedIconPath: "../../static/tabbarImg/tab-sel-3.png",
						iconPath: "../../static/tabbarImg/tab-3.png",
						text: '我的',
						pagePath: "pages/my/my"
					}
				],
			};
		},
		props: {
			current: {
				type: Number,
				default: 1
			}
		},
		methods: {
			changeTab(e){
				uni.switchTab({
					url: '/' + this.list[e-1].pagePath,
				})
				
			}
		}
	}
</script>

<style scoped>
.u-page__item__slot-icon{
        width: 21px!important;
        height: 21px!important;
    }
	
.u-page__item__slot-icon-index{
		width: 20px!important;
		height: 20px!important;
	}
</style>