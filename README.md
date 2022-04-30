# LoadingTextView


```` 
repositories {
      ...
      maven { url "https://www.jitpack.io" }
}
````
<br/>

```` 
dependencies {
      ...
      implementation 'com.github.MrNadimi:LoadingTextView:1.0.1'
}
````

#### xml

````xml
...
<com.mrnadimi.loadingtextview.LoadingTextView
        android:id="@+id/loading_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:text="Loading"
        android:layout_centerInParent="true"
        app:ltv_animateDurationInMills="1000"
        app:ltv_dotCount="3"
        />
        
````

#### java


````java
...
LoadingTextView t = findViewById(R.id.loading_text_view);
t.startTimer();
        
````


