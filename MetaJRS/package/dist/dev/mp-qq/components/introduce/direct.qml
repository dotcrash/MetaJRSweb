<view class="g-bd data-v-4f90cf94"><uni-list class="i-about data-v-4f90cf94" vue-id="4f90bbde-1" bind:__l="__l" vue-slots="{{['default']}}"><block qq:for="{{directions}}" qq:for-item="item" qq:for-index="__i0__"><uni-list-item vue-id="{{('4f90bbde-2-'+__i0__)+','+('4f90bbde-1')}}" direction="row" class="data-v-4f90cf94" bind:__l="__l" vue-slots="{{['header']}}"><view class="m-bd data-v-4f90cf94" slot="header"><view class="title data-v-4f90cf94"><view class="u-tit data-v-4f90cf94">{{''+item.name+''}}</view><view class="u-stit data-v-4f90cf94">{{'About '+item.name+''}}</view><view class="u-line data-v-4f90cf94">line</view></view><view class="i-about data-v-4f90cf94"><view class="intro data-v-4f90cf94"><view class="introText data-v-4f90cf94"><label data-ref="text" class="_span data-v-4f90cf94 vue-ref-in-for">{{''+item.intro+''}}</label></view></view><block qq:if="{{item.type=='video'}}"><view class="m-video data-v-4f90cf94"><video class="u-video data-v-4f90cf94" src="{{item.video}}"></video></view></block><block qq:if="{{item.type=='image'}}"><view style="text-align:center;" class="data-v-4f90cf94"><image class="image-1 data-v-4f90cf94" src="{{item.photo}}" mode="aspectFill"></image></view></block></view></view></uni-list-item></block></uni-list></view>