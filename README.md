# Android_JAVA
Android JAVA

> Bug

Expected receiver of type ..., but got android.view.ContextThemeWrapper

# https://ko.programqa.com/question/34523015/

AppCompat 하위 클래스 활동에 문제가 있습니다. Android의 이슈 트래커에 게시 된 다음 문제를 발견했습니다. https://code.google.com/p/android/issues/detail?id=174871

AppCompat의 인플레이터에 문제가 있는 것 같습니다. 레이아웃 xml의 OnClick 속성에서 생성된 OnClick 핸들러가 ContextWrapper를 제대로 처리하지 못하는 것 같습니다. 해결 방법은 XML에서 OnClick 특성을 제거하고 코드에 프로그래밍 방식으로 OnClick 리스너를 등록하는 것입니다. 

# Set Context of Fragment
```JAVA
View view = inflater.inflate (R.layout.fragment_example, container, false
```

```XML
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:focusable="true"
    android:focusableInTouchMode="true"
    >
```

```XML
    android:focusable="true"
    android:focusableInTouchMode="true"
```
