#include <iostream>
#include <vector>
using namespace std;

class MyHashMap
{
private:
  static const int SIZE = 10007;
  vector<pair<int, int>> map[SIZE];

  int hash(int key)
  {
    return key % SIZE;
  }

public:
  MyHashMap() {}

  void put(int key, int value)
  {
    int h = hash(key);
    for (auto &p : map[h])
    {
      if (p.first == key)
      {
        p.second = value;
        return;
      }
    }
    map[h].push_back({key, value}); // if key not found insert pair at end of vector
  }

  int get(int key)
  {
    int h = hash(key);
    for (auto &p : map[h])
    {
      if (p.first == key)
        return p.second;
    }
    return -1;
  }

  void remove(int key)
  {
    int h = hash(key);
    for (auto it = map[h].begin(); it != map[h].end(); ++it)
    {
      if (it->first == key)
      {
        map[h].erase(it);
        return;
      }
    }
  }
};

int main()
{
  MyHashMap obj;
  obj.put(1, 10);
  obj.put(2, 20);
  cout << obj.get(1) << endl;
  cout << obj.get(3) << endl;
  obj.put(2, 30);
  cout << obj.get(2) << endl;
  obj.remove(2);
  cout << obj.get(2) << endl;
  return 0;
}
