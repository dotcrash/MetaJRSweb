<view class="g-bd data-v-2f06f73c"><view style="display:flex;flex-direction:column;align-items:center;" class="data-v-2f06f73c"><view class="m-bd data-v-2f06f73c"><view class="title data-v-2f06f73c"><view class="u-tit data-v-2f06f73c">{{''+teaminfo.name+''}}</view><view class="u-stit data-v-2f06f73c">{{'About '+teaminfo.name+''}}</view><view class="u-line data-v-2f06f73c">line</view></view><view class="i-about data-v-2f06f73c"><view class="m-video data-v-2f06f73c"><video class="u-video data-v-2f06f73c" src="{{teaminfo.video}}"></video></view><view style="height:30rpx;" class="data-v-2f06f73c"></view><view class="u-video data-v-2f06f73c" style="width:600rpx;border:2px solid grey;margin-left:20rpx;font-size:30rpx;"><ideaintro vue-id="2f071ea8-1" line="{{3}}" expandText="展开" foldHint="收起" enableButton="true" class="data-v-2f06f73c" bind:__l="__l"></ideaintro></view></view></view><view class="m-bd data-v-2f06f73c"><view class="title data-v-2f06f73c"><view class="u-tit data-v-2f06f73c">团队风采</view><view class="u-stit data-v-2f06f73c">About Teams</view><view class="u-line data-v-2f06f73c">line</view></view><uni-list class="i-about data-v-2f06f73c" vue-id="2f071ea8-2" bind:__l="__l" vue-slots="{{['default']}}"><block qq:for="{{teaminfo.teamelegant}}" qq:for-item="item" qq:for-index="__i0__"><uni-list-item vue-id="{{('2f071ea8-3-'+__i0__)+','+('2f071ea8-2')}}" direction="row" class="data-v-2f06f73c" bind:__l="__l" vue-slots="{{['header']}}"><view slot="header"><block qq:if="{{item.type=='video'}}"><view class="m-video1 data-v-2f06f73c" style="text-align:center;"><video class="u-video1 data-v-2f06f73c" src="{{item.url}}" mode="aspectFill"></video>{{''+item.name}}</view></block><block qq:if="{{item.type=='image'}}"><view style="text-align:center;" class="data-v-2f06f73c"><image class="image-1 data-v-2f06f73c" src="{{item.url}}" mode="aspectFill"></image>{{''+item.name+''}}</view></block></view></uni-list-item></block></uni-list></view><view class="m-bd data-v-2f06f73c"><view class="title data-v-2f06f73c"><view class="u-tit data-v-2f06f73c">加入我们</view><view class="u-stit data-v-2f06f73c">Join Us</view><view class="u-line data-v-2f06f73c">line</view></view><uni-list class="i-about data-v-2f06f73c" vue-id="2f071ea8-4" bind:__l="__l" vue-slots="{{['default']}}"><block qq:for="{{this.teaminfo.joinus}}" qq:for-item="item" qq:for-index="__i1__"><uni-list-item vue-id="{{('2f071ea8-5-'+__i1__)+','+('2f071ea8-4')}}" direction="row" class="data-v-2f06f73c" bind:__l="__l" vue-slots="{{['header']}}"><view slot="header"><block qq:if="{{item.type=='video'}}"><view class="m-video1 data-v-2f06f73c" style="text-align:center;"><video class="u-video1 data-v-2f06f73c" src="{{item.url}}" mode="aspectFill"></video>{{''+item.name}}</view></block><block qq:if="{{item.type=='image'}}"><view style="text-align:center;" class="data-v-2f06f73c"><image class="image-1 data-v-2f06f73c" src="{{item.url}}" mode="aspectFill"></image>{{''+item.name+''}}</view></block></view></uni-list-item></block></uni-list></view></view></view>