package com.example.cattlediseaseprediction;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TreatmentActivity extends AppCompatActivity {

    private AutoCompleteTextView searchField;
    private TextView nameTextView, descriptionTextView, treatmentTextView;
    private View resultCard;
    private List<Disease> diseaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);


        searchField = findViewById(R.id.searchTreatmentField);
        nameTextView = findViewById(R.id.diseaseNameTextView);
        descriptionTextView = findViewById(R.id.diseaseDescriptionTextView);
        treatmentTextView = findViewById(R.id.diseaseTreatmentTextView);
        resultCard = findViewById(R.id.resultCard);

        // at start hide the card view
        resultCard.setVisibility(View.GONE);

        // Populate the disease list
        diseaseList = new ArrayList<>();
        populateDiseaseList();

        // Extract disease names for the dropdown
        List<String> diseaseNames = new ArrayList<>();
        for (Disease disease : diseaseList) {
            diseaseNames.add(disease.getName());
        }

        // Set up AutoCompleteTextView with disease names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, diseaseNames);
        searchField.setAdapter(adapter);

        // Set a listener for selection from dropdown
        searchField.setOnItemClickListener((parent, view, position, id) -> {
            String selectedDisease = searchField.getText().toString();
            displayDiseaseDetails(selectedDisease);
        });
    }

    private void populateDiseaseList() {
        diseaseList.add(new Disease(
                "Mastitis",
                "Infection of the udder tissue, often caused by bacteria. Symptoms include swelling of the udder, reduced milk production, and pain in the udder. / " +
                        "تھنوں کے ٹشو کا انفیکشن جو عموماً بیکٹیریا کی وجہ سے ہوتا ہے۔ علامات میں تھنوں کی سوجن، دودھ کی مقدار میں کمی، اور تھنوں میں درد شامل ہیں۔",
                "Treatment:\n" +
                        "- Use antibiotic therapy as prescribed by a veterinarian.\n" +
                        "- Maintain proper milking hygiene to prevent infection.\n" +
                        "- Separate the infected animal to prevent spreading to others.\n" +
                        "- Consult a veterinarian if symptoms persist. / " +
                        "علاج:\n" +
                        "- ویٹرنری ڈاکٹر کے مشورے سے اینٹی بائیوٹک ادویات استعمال کریں۔\n" +
                        "- دودھ دوہنے کے دوران صفائی کا خاص خیال رکھیں۔\n" +
                        "- متاثرہ جانور کو علیحدہ رکھیں تاکہ انفیکشن دوسرے جانوروں تک نہ پھیلے۔\n" +
                        "- اگر علامات برقرار رہیں تو ویٹرنری ڈاکٹر سے رجوع کریں۔"
        ));

        diseaseList.add(new Disease(
                "Blackleg",
                "A bacterial disease caused by *Clostridium chauvoei*, leading to severe swelling of muscles, lameness, and rapid death if untreated. / " +
                        "*Clostridium chauvoei* بیکٹیریا کی وجہ سے ہونے والی بیماری، جو عضلات کی شدید سوجن، لنگڑا پن، اور علاج نہ ہونے پر جلد موت کا باعث بن سکتی ہے۔",
                "Treatment:\n" +
                        "- Administer antibiotics such as penicillin at the earliest.\n" +
                        "- Vaccinate the herd to prevent future cases.\n" +
                        "- Always consult a veterinarian immediately, as this disease can progress rapidly. / " +
                        "علاج:\n" +
                        "- ابتدائی مرحلے میں پینسلین جیسے اینٹی بائیوٹکس دیں۔\n" +
                        "- مستقبل میں بیماری سے بچاؤ کے لیے جانوروں کو ویکسین لگائیں۔\n" +
                        "- ہمیشہ فوراً ویٹرنری ڈاکٹر سے مشورہ کریں کیونکہ یہ بیماری بہت تیزی سے بڑھ سکتی ہے۔"
        ));

        diseaseList.add(new Disease(
                "Bloat",
                "Occurs when the stomach fills with gas, causing difficulty in breathing and movement. Symptoms include distended abdomen and restlessness. / " +
                        "یہ بیماری معدے میں گیس بھر جانے سے ہوتی ہے، جس کی وجہ سے سانس لینے اور حرکت میں دشواری ہوتی ہے۔ علامات میں پیٹ کا پھولنا اور بےچینی شامل ہیں۔",
                "Treatment:\n" +
                        "- Administer antacid medications to reduce gas.\n" +
                        "- If severe, decompression with a special tube or needle is needed, which requires veterinary expertise.\n" +
                        "- Reduce high-fermentable feeds in the diet.\n" +
                        "- Consult a veterinarian immediately if symptoms are severe. / " +
                        "علاج:\n" +
                        "- گیس کم کرنے کے لیے اینٹاسڈ ادویات دیں۔\n" +
                        "- اگر صورتحال سنگین ہو تو معدے کو ڈی کمپریس کرنے کے لیے خصوصی ٹیوب یا سوئی استعمال کریں، جو ویٹرنری ماہر کے ذریعے ممکن ہے۔\n" +
                        "- خوراک میں زیادہ خمیر پیدا کرنے والی اشیاء کو کم کریں۔\n" +
                        "- اگر علامات شدید ہوں تو فوراً ویٹرنری ڈاکٹر سے رجوع کریں۔"
        ));

        diseaseList.add(new Disease(
                "Coccidiosis",
                "A parasitic disease causing diarrhea, especially in young cattle. Other symptoms include dehydration and weakness. / " +
                        "ایک پرجیوی بیماری جو اسہال کا باعث بنتی ہے، خاص طور پر جوان گائے میں۔ دیگر علامات میں پانی کی کمی اور کمزوری شامل ہیں۔",
                "Treatment:\n" +
                        "- Use anticoccidial drugs as prescribed by a veterinarian.\n" +
                        "- Ensure good hygiene in the animal's living area to prevent reinfection.\n" +
                        "- Provide clean water and electrolytes to manage dehydration.\n" +
                        "- Consult a veterinarian for severe or prolonged cases. / " +
                        "علاج:\n" +
                        "- ویٹرنری ڈاکٹر کے مشورے سے اینٹی کوکسائیڈیل دوائیں استعمال کریں۔\n" +
                        "- جانور کے رہنے کی جگہ میں صفائی کو یقینی بنائیں تاکہ دوبارہ انفیکشن سے بچا جا سکے۔\n" +
                        "- پانی کی کمی کے لیے صاف پانی اور الیکٹرولائٹ فراہم کریں۔\n" +
                        "- شدید یا طویل کیسز میں ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));

        diseaseList.add(new Disease(
                "Cryptosporidiosis",
                "An intestinal infection causing severe diarrhea, often in calves. Symptoms include dehydration and weight loss. / " +
                        "ایک آنتوں کا انفیکشن جو عموماً بچھڑوں میں شدید اسہال کا باعث بنتا ہے۔ علامات میں پانی کی کمی اور وزن میں کمی شامل ہیں۔",
                "Treatment:\n" +
                        "- Provide oral rehydration solutions to prevent dehydration.\n" +
                        "- Keep the calf's environment clean and dry to limit parasite exposure.\n" +
                        "- Consult a veterinarian if the diarrhea persists or the calf shows signs of severe weakness. / " +
                        "علاج:\n" +
                        "- پانی کی کمی سے بچانے کے لیے زبانی ری ہائیڈریشن کے محلول دیں۔\n" +
                        "- بچھڑے کے ماحول کو صاف اور خشک رکھیں تاکہ پرجیویوں کی نمائش کو محدود کیا جا سکے۔\n" +
                        "- اگر اسہال برقرار رہے یا بچھڑا شدید کمزوری ظاہر کرے تو ویٹرنری ڈاکٹر سے رجوع کریں۔"
        ));

        diseaseList.add(new Disease(
                "Displaced Abomasum",
                "Occurs when the abomasum (stomach) moves out of its normal position, leading to reduced appetite and milk production. / " +
                        "جب معدہ اپنی عام جگہ سے ہٹ جاتا ہے، جس کی وجہ سے بھوک اور دودھ کی پیداوار میں کمی ہوتی ہے۔",
                "Treatment:\n" +
                        "- For mild cases, the rolling technique may help reposition the stomach.\n" +
                        "- Severe cases require surgical intervention.\n" +
                        "- Always consult a veterinarian to determine the appropriate treatment. / " +
                        "علاج:\n" +
                        "- ہلکے کیسز میں رولنگ تکنیک معدے کو دوبارہ اپنی جگہ پر لانے میں مددگار ہو سکتی ہے۔\n" +
                        "- شدید کیسز میں سرجری کی ضرورت ہوتی ہے۔\n" +
                        "- ہمیشہ ویٹرنری ڈاکٹر سے مشورہ کریں تاکہ مناسب علاج کیا جا سکے۔"
        ));
        diseaseList.add(new Disease(
                "Gut Worms",
                "Intestinal worms causing discomfort, weight loss, and sometimes diarrhea in cattle. / " +
                        "آنتوں کے کیڑے جو گائے میں تکلیف، وزن میں کمی، اور کبھی کبھار اسہال کا باعث بنتے ہیں۔",
                "Treatment:\n" +
                        "- Use anthelmintic drugs to treat the worms.\n" +
                        "- Ensure proper sanitation and deworming schedule for the entire herd.\n" +
                        "- Consult a veterinarian for appropriate drug recommendations. / " +
                        "علاج:\n" +
                        "- کیڑوں کے علاج کے لیے اینٹی ہلمنٹک دوائیں استعمال کریں۔\n" +
                        "- پورے ریوڑ کے لیے مناسب صفائی اور ڈیورمنگ شیڈول کو یقینی بنائیں۔\n" +
                        "- مناسب دوا کی تجویز کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        diseaseList.add(new Disease(
                "Listeriosis",
                "A bacterial infection caused by Listeria monocytogenes, leading to neurological symptoms and sometimes abortion. / " +
                        "Listeria monocytogenes کے بیکٹیریا کی وجہ سے ہونے والی بیماری، جو اعصابی علامات اور کبھی کبھار اسقاط حمل کا باعث بنتی ہے۔",
                "Treatment:\n" +
                        "- Administer appropriate antibiotics such as penicillin.\n" +
                        "- Ensure good hygiene and avoid feeding silage that may be contaminated.\n" +
                        "- Always consult a veterinarian for proper management. / " +
                        "علاج:\n" +
                        "- مناسب اینٹی بائیوٹکس جیسے پینسلین دیں۔\n" +
                        "- اچھی صفائی کو یقینی بنائیں اور آلودہ ہونے والے سیلیج سے بچیں۔\n" +
                        "- مناسب انتظام کے لیے ہمیشہ ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        // Liver Fluke
        diseaseList.add(new Disease(
                "Liver Fluke",
                "A parasitic infection affecting the liver, causing anemia, weight loss, and poor growth. / " +
                        "کسی پرجیوی کی وجہ سے جگر کا انفیکشن ہوتا ہے، جو خون کی کمی، وزن میں کمی، اور کمزور بڑھوتری کا باعث بنتا ہے۔",
                "Treatment:\n" +
                        "- Administer anthelmintic drugs like Triclabendazole or Closantel.\n" +
                        "- Ensure good pasture management to prevent fluke larvae.\n" +
                        "- Consult a veterinarian for proper diagnosis and treatment. / " +
                        "علاج:\n" +
                        "- اینٹی ہلمنٹک دوائیں جیسے ٹرائیکلیبینڈی زول یا کلوسینٹیل دیں۔\n" +
                        "- فلوک لاروا سے بچاؤ کے لیے بہترین چراگاہ کے انتظام کو یقینی بنائیں۔\n" +
                        "- مناسب تشخیص اور علاج کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        // Necrotic Enteritis
        diseaseList.add(new Disease(
                "Necrotic Enteritis",
                "A bacterial infection causing severe inflammation of the intestines, leading to diarrhea, bloating, and high mortality. / " +
                        "ایک بیکٹیریائی انفیکشن جو آنتوں کی شدید سوزش کا سبب بنتا ہے، جس کی وجہ سے اسہال، گیس اور زیادہ اموات ہوتی ہیں۔",
                "Treatment:\n" +
                        "- Use antibiotics like penicillin and metronidazole.\n" +
                        "- Ensure good hygiene and clean the feeding equipment regularly.\n" +
                        "- Consult a veterinarian for appropriate drug therapy. / " +
                        "علاج:\n" +
                        "- پینسلین اور میٹرانائڈازول جیسے اینٹی بائیوٹکس استعمال کریں۔\n" +
                        "- اچھی صفائی کو یقینی بنائیں اور خوراک دینے والے سامان کو باقاعدگی سے صاف کریں۔\n" +
                        "- مناسب دوا کے علاج کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        // Peri-Weaning Diarrhoea
        diseaseList.add(new Disease(
                "Peri-Weaning Diarrhoea",
                "Diarrhea occurring around the time of weaning, often due to stress, diet change, or infections. / " +
                        "اسہال جو دودھ چھڑانے کے وقت کے قریب ہوتا ہے، عام طور پر دباؤ، خوراک کی تبدیلی، یا انفیکشن کی وجہ سے ہوتا ہے۔",
                "Treatment:\n" +
                        "- Provide oral rehydration solutions to prevent dehydration.\n" +
                        "- Adjust the diet to improve gut health.\n" +
                        "- Consult a veterinarian if the condition persists. / " +
                        "علاج:\n" +
                        "- پانی کی کمی سے بچانے کے لیے زبانی ری ہائیڈریشن کے محلول دیں۔\n" +
                        "- آنتوں کی صحت بہتر بنانے کے لیے خوراک میں تبدیلی کریں۔\n" +
                        "- اگر بیماری برقرار رہے تو ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        // Rift Valley Fever
        diseaseList.add(new Disease(
                "Rift Valley Fever",
                "A viral disease causing fever, abortions, and high mortality in cattle, transmitted by mosquitoes. / " +
                        "ایک وائرل بیماری جو بخار، اسقاط حمل اور گائے میں زیادہ اموات کا باعث بنتی ہے، جو مچھروں کے ذریعے منتقل ہوتی ہے۔",
                "Treatment:\n" +
                        "- There is no specific antiviral treatment.\n" +
                        "- Supportive care for symptoms, such as fever reduction and fluid therapy.\n" +
                        "- Vaccination is recommended for prevention. / " +
                        "علاج:\n" +
                        "- کوئی مخصوص اینٹی وائرل علاج نہیں ہے۔\n" +
                        "- بخار کم کرنے اور سیال تھراپی جیسے علامات کے لیے معاون دیکھ بھال۔\n" +
                        "- بچاؤ کے لیے ویکسی نیشن کی سفارش کی جاتی ہے۔"
        ));
        // Rumen Acidosis
        diseaseList.add(new Disease(
                "Rumen Acidosis",
                "Occurs when there is an excessive accumulation of lactic acid in the rumen, leading to loss of appetite, diarrhea, and lethargy. / " +
                        "یہ اس وقت ہوتا ہے جب رمین میں لییکٹک ایسڈ کی زیادہ مقدار جمع ہو جاتی ہے، جس سے بھوک میں کمی، اسہال، اور تھکاوٹ پیدا ہوتی ہے۔",
                "Treatment:\n" +
                        "- Correct the diet by reducing high starch feeds.\n" +
                        "- Administer antacids to neutralize excess acid in the rumen.\n" +
                        "- Provide electrolytes to restore balance. / " +
                        "علاج:\n" +
                        "- خوراک میں نشاستہ والی اشیاء کی مقدار کم کر کے خوراک کو درست کریں۔\n" +
                        "- رمین میں اضافی ایسڈ کو نیوٹرل کرنے کے لیے اینٹاسڈ دوائیں دیں۔\n" +
                        "- توازن کو بحال کرنے کے لیے الیکٹرولائٹس فراہم کریں۔"
        ));
        // Traumatic Reticulitis
        diseaseList.add(new Disease(
                "Traumatic Reticulitis",
                "Infection caused by foreign objects in the reticulum, leading to inflammation, fever, and reduced appetite. / " +
                        "غیر ملکی اشیاء کی وجہ سے ریٹیکولم میں ہونے والا انفیکشن، جو سوزش، بخار، اور بھوک میں کمی کا باعث بنتا ہے۔",
                "Treatment:\n" +
                        "- Administer antibiotics to treat infection.\n" +
                        "- In some cases, surgery may be required to remove the foreign object.\n" +
                        "- Provide pain relief as necessary. / " +
                        "علاج:\n" +
                        "- انفیکشن کے علاج کے لیے اینٹی بائیوٹکس دیں۔\n" +
                        "- بعض کیسز میں غیر ملکی اشیاء کو نکالنے کے لیے سرجری کی ضرورت ہو سکتی ہے۔\n" +
                        "- ضروری ہو تو درد کی دوا فراہم کریں۔"
        ));
        // Calf Diphtheria
        diseaseList.add(new Disease(
                "Calf Diphtheria",
                "A bacterial infection in calves causing a thick membrane in the throat, leading to breathing difficulties. / " +
                        "بچھڑوں میں ایک بیکٹیریائی انفیکشن جو گلے میں موٹی جھلی پیدا کرتا ہے، جس سے سانس لینے میں مشکلات ہوتی ہیں۔",
                "Treatment:\n" +
                        "- Administer antibiotics like penicillin.\n" +
                        "- Provide supportive care such as fluids and pain relief.\n" +
                        "- Ensure a clean, dry environment for the calf. / " +
                        "علاج:\n" +
                        "- پینسلین جیسے اینٹی بائیوٹکس دیں۔\n" +
                        "- معاون دیکھ بھال فراہم کریں جیسے سیال اور درد کی دوا۔\n" +
                        "- بچھڑے کے لیے صاف اور خشک ماحول کو یقینی بنائیں۔"
        ));
        // Foot Rot
        diseaseList.add(new Disease(
                "Foot Rot",
                "A bacterial infection affecting the hooves, causing swelling, pain, and difficulty in walking. / " +
                        "ایک بیکٹیریائی انفیکشن جو کھروں کو متاثر کرتا ہے، جس سے سوجن، درد اور چلنے میں مشکل ہوتی ہے۔",
                "Treatment:\n" +
                        "- Trim the hooves and clean the affected area.\n" +
                        "- Use antibiotics and anti-inflammatory drugs.\n" +
                        "- Ensure proper hoof hygiene to prevent recurrence. / " +
                        "علاج:\n" +
                        "- کھروں کو تراش کر متاثرہ جگہ کو صاف کریں۔\n" +
                        "- اینٹی بائیوٹکس اور اینٹی سوزش والی دوائیں استعمال کریں۔\n" +
                        "- دوبارہ ہونے سے بچانے کے لیے کھروں کی صفائی کا خیال رکھیں۔"
        ));
// Foot-and-Mouth
        diseaseList.add(new Disease(
                "Foot-and-Mouth",
                "A viral disease causing fever, blisters, and sores in the mouth and hooves. / " +
                        "ایک وائرل بیماری جو بخار، چھالے اور منہ اور کھروں میں زخموں کا سبب بنتی ہے۔",
                "Treatment:\n" +
                        "- There is no specific antiviral treatment.\n" +
                        "- Provide supportive care such as pain relief and fluid therapy.\n" +
                        "- Preventive vaccination is recommended. / " +
                        "علاج:\n" +
                        "- کوئی مخصوص اینٹی وائرل علاج نہیں ہے۔\n" +
                        "- معاون دیکھ بھال فراہم کریں جیسے درد کی دوا اور سیال تھراپی۔\n" +
                        "- بچاؤ کے لیے ویکسی نیشن کی سفارش کی جاتی ہے۔"
        ));
        // Ragwort Poisoning
        diseaseList.add(new Disease(
                "Ragwort Poisoning",
                "Poisoning caused by the ingestion of ragwort plant, leading to liver damage and jaundice. / " +
                        "رگ ورٹ پودے کے کھانے سے زہر آنا، جو جگر کے نقصان اور یرقان کا باعث بنتا ہے۔",
                "Treatment:\n" +
                        "- There is no specific antidote, treatment is supportive.\n" +
                        "- Provide fluids, vitamins, and antioxidants.\n" +
                        "- Prevent access to ragwort plants. / " +
                        "علاج:\n" +
                        "- کوئی مخصوص تریاق نہیں ہے، علاج معاون ہوتا ہے۔\n" +
                        "- سیال، وٹامنز، اور اینٹی آکسیڈینٹس فراہم کریں۔\n" +
                        "- رگ ورٹ پودوں تک رسائی کو روکیں۔"
        ));
        // Wooden Tongue
        diseaseList.add(new Disease(
                "Wooden Tongue",
                "A bacterial infection in cattle affecting the tongue, causing swelling and difficulty in eating. / " +
                        "گائے میں ایک بیکٹیریائی انفیکشن جو زبان کو متاثر کرتا ہے، جس سے سوجن اور کھانے میں مشکل ہوتی ہے۔",
                "Treatment:\n" +
                        "- Use antibiotics like tetracycline.\n" +
                        "- Provide supportive care such as fluid therapy.\n" +
                        "- Ensure the animal is able to drink water. / " +
                        "علاج:\n" +
                        "- ٹیٹرسی کلین جیسے اینٹی بائیوٹکس استعمال کریں۔\n" +
                        "- معاون دیکھ بھال فراہم کریں جیسے سیال تھراپی۔\n" +
                        "- اس بات کو یقینی بنائیں کہ جانور پانی پی سکے۔"
        ));
        // Infectious Bovine Rhinotracheitis (IBR)
        diseaseList.add(new Disease(
                "Infectious Bovine Rhinotracheitis",
                "A viral infection affecting the respiratory tract, causing nasal discharge, fever, and coughing. / " +
                        "ایک وائرل انفیکشن جو سانس کی نالی کو متاثر کرتا ہے، جس سے ناک سے رطوبت، بخار اور کھانسی ہوتی ہے۔",
                "Treatment:\n" +
                        "- Administer antiviral medications and antibiotics for secondary bacterial infections.\n" +
                        "- Provide supportive care like hydration and temperature regulation.\n" +
                        "- Preventive vaccination is advised. / " +
                        "علاج:\n" +
                        "- اینٹی وائرل ادویات اور ضمنی بیکٹیریائی انفیکشن کے لیے اینٹی بائیوٹکس دیں۔\n" +
                        "- معاون دیکھ بھال فراہم کریں جیسے پانی کی کمی کو دور کرنا اور درجہ حرارت کو کنٹرول کرنا۔\n" +
                        "- بچاؤ کے لیے ویکسی نیشن کی سفارش کی جاتی ہے۔"
        ));
        diseaseList.add(new Disease(
                "Acetonemia",
                "A metabolic disorder in cattle, also known as ketosis, caused by a negative energy balance. Symptoms include weight loss, decreased milk production, and a sweet odor on the breath. / " +
                        "گایوں میں ایک میٹابولک بیماری جو کیٹوسس کے نام سے بھی جانی جاتی ہے، یہ توانائی کے منفی توازن کی وجہ سے ہوتی ہے۔ علامات میں وزن میں کمی، دودھ کی پیداوار میں کمی، اور سانس سے میٹھا بدبو آنا شامل ہیں۔",
                "Treatment:\n" +
                        "- Provide glucose or propylene glycol to increase energy levels.\n" +
                        "- Adjust the diet to prevent negative energy balance.\n" +
                        "- Consult a veterinarian for severe cases. / " +
                        "علاج:\n" +
                        "- توانائی کی سطح بڑھانے کے لیے گلوکوز یا پروپائلین گلائیکول دیں۔\n" +
                        "- منفی توانائی کے توازن سے بچنے کے لیے خوراک کو بہتر بنائیں۔\n" +
                        "- شدید کیسز کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        diseaseList.add(new Disease(
                "Fatty Liver Syndrome",
                "A condition where excess fat accumulates in the liver, often linked to metabolic disorders. Symptoms include weight loss, lethargy, and reduced appetite. / " +
                        "ایک حالت جس میں جگر میں اضافی چربی جمع ہو جاتی ہے، جو اکثر میٹابولک بیماریوں سے جڑی ہوتی ہے۔ علامات میں وزن میں کمی، سستی، اور بھوک میں کمی شامل ہیں۔",
                "Treatment:\n" +
                        "- Provide high-energy, easily digestible feed.\n" +
                        "- Minimize stress and ensure proper rest.\n" +
                        "- Consult a veterinarian for appropriate medications. / " +
                        "علاج:\n" +
                        "- توانائی سے بھرپور اور آسانی سے ہضم ہونے والی خوراک دیں۔\n" +
                        "- تناؤ کو کم کریں اور مناسب آرام کو یقینی بنائیں۔\n" +
                        "- مناسب ادویات کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        diseaseList.add(new Disease(
                "Calf Pneumonia",
                "A respiratory infection in calves caused by bacteria or viruses. Symptoms include coughing, fever, nasal discharge, and difficulty breathing. / " +
                        "بچھڑوں میں سانس کی بیماری جو بیکٹیریا یا وائرس کی وجہ سے ہوتی ہے۔ علامات میں کھانسی، بخار، ناک سے پانی بہنا، اور سانس لینے میں دشواری شامل ہیں۔",
                "Treatment:\n" +
                        "- Administer antibiotics or antiviral medication as prescribed.\n" +
                        "- Provide a warm, dry environment for the calf to rest.\n" +
                        "- Consult a veterinarian for proper treatment. / " +
                        "علاج:\n" +
                        "- ویٹرنری ڈاکٹر کے مشورے سے اینٹی بائیوٹک یا اینٹی وائرل دوائیں دیں۔\n" +
                        "- بچھڑے کو آرام کرنے کے لیے گرم اور خشک ماحول فراہم کریں۔\n" +
                        "- مناسب علاج کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        diseaseList.add(new Disease(
                "Schmallenberg Virus",
                "A viral infection causing birth defects, abortions, and fever in cattle. Symptoms include fever, swelling of the limbs, and neurological signs. / " +
                        "ایک وائرس کی بیماری جو گایوں میں پیدائشی نقائص، اسقاط حمل، اور بخار کا باعث بنتی ہے۔ علامات میں بخار، ٹانگوں کی سوجن، اور اعصابی علامات شامل ہیں۔",
                "Treatment:\n" +
                        "- There is no specific antiviral treatment, but supportive care can be provided.\n" +
                        "- Minimize stress and provide a comfortable environment.\n" +
                        "- Vaccination is available for prevention. / " +
                        "علاج:\n" +
                        "- کوئی خاص اینٹی وائرل علاج نہیں ہے، لیکن معاون دیکھ بھال فراہم کی جا سکتی ہے۔\n" +
                        "- تناؤ کو کم کریں اور آرام دہ ماحول فراہم کریں۔\n" +
                        "- بیماری سے بچاؤ کے لیے ویکسین دستیاب ہے۔"
        ));
        diseaseList.add(new Disease(
                "Trypanosomiasis",
                "A parasitic infection transmitted by tsetse flies, causing fever, anemia, and swelling of lymph nodes. / " +
                        "ایک پرجیوی انفیکشن جو ٹسی ٹسی مکھوں کے ذریعے منتقل ہوتا ہے، بخار، خون کی کمی، اور لیمف نوڈس کی سوجن کا باعث بنتی ہے۔",
                "Treatment:\n" +
                        "- Administer trypanocidal drugs as prescribed by a veterinarian.\n" +
                        "- Control tsetse flies and minimize animal exposure to them.\n" +
                        "- Consult a veterinarian for proper treatment. / " +
                        "علاج:\n" +
                        "- ویٹرنری ڈاکٹر کے مشورے سے ٹرائپانوسائیڈل ادویات دیں۔\n" +
                        "- ٹسی ٹسی مکھیوں کو کنٹرول کریں اور جانوروں کو ان سے بچائیں۔\n" +
                        "- مناسب علاج کے لیے ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));
        diseaseList.add(new Disease(
                "Fog Fever",
                "A respiratory disease in cattle caused by the rapid intake of lush, high-protein pasture. Symptoms include coughing, fever, and difficulty breathing. / " +
                        "گایوں میں سانس کی بیماری جو تیز تر اور زیادہ پروٹین والی گھاس کے استعمال سے ہوتی ہے۔ علامات میں کھانسی، بخار، اور سانس لینے میں دشواری شامل ہیں۔",
                "Treatment:\n" +
                        "- Gradually introduce cattle to lush pastures to avoid sudden exposure.\n" +
                        "- Administer anti-inflammatory drugs to reduce symptoms.\n" +
                        "- Consult a veterinarian if symptoms persist. / " +
                        "علاج:\n" +
                        "- گایوں کو گھاس کے باغات میں آہستہ آہستہ متعارف کروائیں تاکہ اچانک نمائش سے بچا جا سکے۔\n" +
                        "- علامات کو کم کرنے کے لیے اینٹی سوزش دوائیں دیں۔\n" +
                        "- اگر علامات برقرار رہیں تو ویٹرنری ڈاکٹر سے مشورہ کریں۔"
        ));

    }

    private void displayDiseaseDetails(String diseaseName) {
        // Find the disease by name
        for (Disease disease : diseaseList) {
            if (disease.getName().equalsIgnoreCase(diseaseName)) {
                nameTextView.setText(disease.getName());
                descriptionTextView.setText(disease.getDescription());
                treatmentTextView.setText(disease.getTreatment());
                resultCard.setVisibility(View.VISIBLE);
                return;
            }
        }

        // If no disease is found, hide the result card and show a message
        resultCard.setVisibility(View.GONE);
    }
}
