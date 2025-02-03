# Android - InsetsWidget

[![Platform](https://img.shields.io/badge/platform-Android-brightgreen)](https://developer.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/github/license/TakWolf/Android-InsetsWidget)](https://www.apache.org/licenses/LICENSE-2.0)
[![JitPack](https://jitpack.io/v/TakWolf/Android-InsetsWidget.svg)](https://jitpack.io/#TakWolf/Android-InsetsWidget)

一组可以动态适配 `WindowInsets` 尺寸的组件，用于快速实现沉浸式布局效果。

您可以通过阅读官方文章来了解什么是 [在应用中全屏显示内容](https://developer.android.com/develop/ui/views/layout/edge-to-edge?hl=zh-cn) 。

## Usage

### Setup

添加依赖：

```kotlin
repositories { 
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.activity:activity-ktx:1.10.0")
    implementation("com.github.TakWolf.Android-InsetsWidget:insetswidget:0.0.1")
    // 可选。为 `ConstraintLayout` 添加支持。
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("com.github.TakWolf.Android-InsetsWidget:constraintlayout:0.0.1")
}
```

在 `Activity` 中启用「边到边」：

```kotlin
class SomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some)
    }
}
```

最后，确保不要在你的布局中使用 `android:fitsSystemWindows="true"` 属性。

该属性会拦截 `WindowInsets` 事件，从而导致组件失效。

### InsetsView

包括：

- `InsetsView`
- `InsetsSpace`

这个类型的组件尺寸会自动适配窗口附加物类型的尺寸。例如：

```xml
<com.takwolf.android.insetswidget.InsetsView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:isw_insetsType="statusBars" />
```

### InsetsLayout

包括：

- `InsetsFrameLayout`
- `InsetsLinearLayout`
- `InsetsNestedScrollView`  
- `InsetsConstraintLayout`

这个类型的组件，会自动添加 `Padding` 来适配窗口附加物类型的尺寸。也可以额外配置颜色。例如：

```xml
<com.takwolf.android.insetswidget.InsetsLinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    app:isw_insetsType="statusBars|navigationBars"
    app:isw_insetsPaddingBottom="false"
    app:isw_insetsColorTop="@color/translucent_black"
    app:isw_insetsColorBottom="@color/translucent_black">
    
    <YourView />
    
</com.takwolf.android.insetswidget.InsetsLinearLayout>
```

## License

```
Copyright 2022 TakWolf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
