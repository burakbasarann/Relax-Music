package com.basaran.relaxmusic

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rain=MediaPlayer.create(applicationContext,R.raw.rain)
        val dalga=MediaPlayer.create(applicationContext,R.raw.dalga)
        val yaprak=MediaPlayer.create(applicationContext,R.raw.yaprak)
        val yildirim=MediaPlayer.create(applicationContext,R.raw.yildirim)
        val orman=MediaPlayer.create(applicationContext, R.raw.orman)
        val kus=MediaPlayer.create(applicationContext,R.raw.kus)
        val bg=findViewById(R.id.bg) as ConstraintLayout
        val imgrain=findViewById(R.id.imagerain) as ImageView
        val imgrainstop=findViewById(R.id.imagerainstop) as ImageView
        val imgdalgastart=findViewById(R.id.imagedalgastart) as ImageView
        val imgdalgastop=findViewById(R.id.imagedalgastop) as ImageView
        val imgyaprakstart=findViewById(R.id.imageyaprakstart) as ImageView
        val imgyaprakstop=findViewById(R.id.imageyaprakstop) as ImageView
        val imgyildirimstart=findViewById(R.id.imageyildirimstart) as ImageView
        val imgyildirimstop=findViewById(R.id.imageyildirimstop) as ImageView
        val imgdurdur=findViewById(R.id.imagedurdurstart) as ImageView
        val imgormanstart=findViewById(R.id.imageagacstart) as ImageView
        val imgormanstop=findViewById(R.id.imageagacstop) as ImageView
        val imgkusstart=findViewById(R.id.imagekusstart) as ImageView
        val imgkusstop=findViewById(R.id.imagekusstop) as ImageView
        val txtaciklama=findViewById(R.id.txtaciklama) as TextView
        val txttimer=findViewById(R.id.txttimer) as TextView
        val btntimer=findViewById(R.id.btntimer) as Button
        val btntimerstop=findViewById(R.id.btntimerstop) as Button
        val seekbarrain=findViewById(R.id.seekbarrain) as SeekBar
        val seekbardalga=findViewById(R.id.seekbardalga) as SeekBar
        val seekbaryaprak=findViewById(R.id.seekbaryaprak) as SeekBar
        val seekbarorman=findViewById(R.id.seekbarorman) as SeekBar
        val seekbaryildirim=findViewById(R.id.seekbaryildirim) as SeekBar
        val seekbarkus=findViewById(R.id.seekbarkus) as SeekBar
        val relaxjpg=(R.drawable.relax)
        imgdalgastop.visibility=View.INVISIBLE
        imgrainstop.visibility=View.INVISIBLE
        imgyaprakstop.visibility=View.INVISIBLE
        imgyildirimstop.visibility=View.INVISIBLE
        imgkusstop.visibility=View.INVISIBLE
        imgdurdur.visibility=View.INVISIBLE
        imgormanstop.visibility=View.INVISIBLE
        btntimerstop.visibility=View.INVISIBLE
        bg.setBackgroundResource(relaxjpg)
        txttimer.setText("10 Dakikalık Sayaç")


        seekbarkus.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                kus.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        seekbaryildirim.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                yildirim.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        seekbarorman.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                orman.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        seekbarrain.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                rain.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        seekbardalga.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                dalga.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        seekbaryaprak.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                yaprak.setVolume(progress/100f,progress/100f)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        /* Sayaç yaptık */
        val sayac= object :CountDownTimer(600000,1000) {
            override fun onTick(i: Long) {

                if (btntimerstop.isInvisible == true) {
                    txttimer.setText("10 Dakikalık Sayaç")

                } else {

                    txttimer.setText("Kalan Süre : ${i / 1000} sn")
                }


            }

            override fun onFinish() {
                dalga.pause()
                yaprak.pause()
                rain.pause()
                yildirim.pause()
                orman.pause()
                kus.pause()
                imgdurdur.visibility = View.INVISIBLE
                imgdalgastop.visibility = View.INVISIBLE
                imgrainstop.visibility = View.INVISIBLE
                imgyaprakstop.visibility = View.INVISIBLE
                imgyildirimstop.visibility = View.INVISIBLE
                imgormanstop.visibility = View.INVISIBLE
                imgkusstop.visibility = View.INVISIBLE
                imgrain.visibility = View.VISIBLE
                imgdalgastart.visibility = View.VISIBLE
                imgyaprakstart.visibility = View.VISIBLE
                imgyildirimstart.visibility = View.VISIBLE
                imgormanstart.visibility = View.VISIBLE
                imgkusstart.visibility = View.VISIBLE
                Toast.makeText(getApplicationContext(), "Tüm Sesler Durduruldu.", Toast.LENGTH_SHORT).show();
            }

        }
        sayac.start()
        /* Sayaç Kodu Bitti Kral*/
        fun startTimer(){//bu fonksiyon ile sayaç çalışacak reis
            sayac.start()
        }
        fun stopTimer(){//bu fonksiyonu çağırarak sayaçı durduracağız
            sayac.cancel()
        }
        btntimer.setOnClickListener{
            btntimerstop.visibility=View.VISIBLE
            btntimer.visibility=View.INVISIBLE
            startTimer()


        }
        btntimerstop.setOnClickListener{
            txttimer.setText("10 Dakikalık Sayaç")
            btntimer.visibility=View.VISIBLE
            btntimerstop.visibility=View.INVISIBLE
            stopTimer()
        }
        imgdurdur.setOnClickListener{
            if(dalga.isPlaying)dalga.pause()
            if(yaprak.isPlaying)yaprak.pause()
            if(dalga.isPlaying) dalga.pause()
            if(rain.isPlaying)  rain.pause()
            if(yildirim.isPlaying) yildirim.pause()
            if(orman.isPlaying) orman.pause()
            if(kus.isPlaying) kus.pause()
            imgdurdur.visibility=View.INVISIBLE
            imgdalgastop.visibility=View.INVISIBLE
            imgrainstop.visibility=View.INVISIBLE
            imgyaprakstop.visibility=View.INVISIBLE
            imgyildirimstop.visibility=View.INVISIBLE
            imgormanstop.visibility=View.INVISIBLE
            imgkusstop.visibility=View.INVISIBLE
            imgrain.visibility=View.VISIBLE
            imgdalgastart.visibility=View.VISIBLE
            imgyaprakstart.visibility=View.VISIBLE
            imgyildirimstart.visibility=View.VISIBLE
            imgormanstart.visibility=View.VISIBLE
            imgkusstart.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Tüm Sesler Durduruldu.", Toast.LENGTH_SHORT).show();

        }

        imgkusstart.setOnClickListener(){
            kus.start()
            imgkusstart.visibility=View.INVISIBLE
            imgkusstop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Kuş Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE

        }
        imgkusstop.setOnClickListener{
            kus.pause()
            imgkusstart.visibility=View.VISIBLE
            imgkusstop.visibility=View.INVISIBLE
            Toast.makeText(getApplicationContext(),"Kuş Sesi Durduruldu.", Toast.LENGTH_SHORT).show();
        }

        imgormanstart.setOnClickListener(){
            orman.start()
            imgormanstart.visibility=View.INVISIBLE
            imgormanstop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Orman Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE
        }
        imgormanstop.setOnClickListener{
            orman.pause()
            imgormanstart.visibility=View.VISIBLE
            imgormanstop.visibility=View.INVISIBLE
            Toast.makeText(getApplicationContext(),"Orman Sesi Durduruldu.", Toast.LENGTH_SHORT).show();
        }
        imgrain.setOnClickListener(){
            rain.start()
            imgrain.visibility=View.INVISIBLE
            imgrainstop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Yağmur Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE
        }
        imgrainstop.setOnClickListener{
            rain.pause()
            imgrain.visibility=View.VISIBLE
            imgrainstop.visibility=View.INVISIBLE
            Toast.makeText(getApplicationContext(),"Yağmur Sesi Durduruldu.", Toast.LENGTH_SHORT).show();

        }

        imgdalgastart.setOnClickListener{
            dalga.start()
            imgdalgastart.visibility=View.INVISIBLE
            imgdalgastop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Dalga Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE
        }

        imgdalgastop.setOnClickListener{
            dalga.pause()
            imgdalgastop.visibility=View.INVISIBLE
            imgdalgastart.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Dalga Sesi Durduruldu.", Toast.LENGTH_SHORT).show();
        }

        imgyaprakstart.setOnClickListener{
            yaprak.start()
            imgyaprakstart.visibility=View.INVISIBLE
            imgyaprakstop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Yaprak Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE
        }

        imgyaprakstop.setOnClickListener{
            yaprak.pause()
            imgyaprakstop.visibility=View.INVISIBLE
            imgyaprakstart.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Yaprak Sesi Durduruldu.", Toast.LENGTH_SHORT).show();
        }

        imgyildirimstart.setOnClickListener{
            yildirim.start()
            imgyildirimstart.visibility=View.INVISIBLE
            imgyildirimstop.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Yıldırım Sesi Başlatıldı.", Toast.LENGTH_SHORT).show();
            imgdurdur.visibility=View.VISIBLE
            txtaciklama.visibility=View.INVISIBLE
        }

        imgyildirimstop.setOnClickListener{
            yildirim.pause()
            imgyildirimstop.visibility=View.INVISIBLE
            imgyildirimstart.visibility=View.VISIBLE
            Toast.makeText(getApplicationContext(),"Yıldırım Sesi Durduruldu.", Toast.LENGTH_SHORT).show();
        }





    }
}