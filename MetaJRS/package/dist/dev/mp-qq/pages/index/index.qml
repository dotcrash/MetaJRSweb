<view class="g-box"><view class="g-hd"><swiper class="m-banner" indicator-dots="{{swiper.indicatorDots}}" indicator-color="{{swiper.indicatorColor}}" indicator-active-color="{{swiper.indicatorActiveColor}}" autoplay="{{swiper.autoplay}}" interval="{{swiper.interval}}" duration="{{swiper.duration}}"><block qq:for="{{banners}}" qq:for-item="item" qq:for-index="__i0__"><swiper-item class="swiper-item"><image src="{{item.url}}" mode></image></swiper-item></block></swiper></view><view class="g-bd"><view class="m-bd"><view class="title"><view class="u-tit">团队介绍</view><view class="u-stit">{{'About '+teaminfo.name+''}}</view><view class="u-line">line</view></view><view class="i-about"><view class="img-box"><image class="img-about" src="{{teaminfo.introphoto}}"></image></view><view class="about-con"><view style="border-radius:15px;"><linsindex vue-id="57282994-1" line="{{3}}" expandText="展开" foldHint="收起" enableButton="true" bind:__l="__l"></linsindex></view></view></view></view><view class="m-bd"><view class="title"><view class="u-tit">产品总览</view><view class="u-stit">Products List</view><view class="u-line">line</view></view><block qq:for="{{directions}}" qq:for-item="item" qq:for-index="__i1__"><view class="g-product"><view class="i-product"><view><view class="pro-img"><image src="{{item.logo}}" mode></image></view></view><view class="pro-con"><view class="pro-tit">{{''+item.name+''}}</view><view class="pro-desc">{{''+item.intro+''}}</view></view></view></view></block></view><view class="m-bd"><view class="title"><view class="u-tit">游戏试玩</view><view class="u-stit">Game Play</view><view class="u-line">line</view></view><view class="g-product"><button class="button-yuanjiao" lang="zh_CN" hover-class="bg-click" data-event-opts="{{[['tap',[['downapk',['$event']]]]]}}" bindtap="__e">MetaJRSHero下载</button></view></view></view></view>